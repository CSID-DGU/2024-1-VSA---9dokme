import axios from "axios";
import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const LoginLoading = () => {
  const code = new URL(window.location.href).searchParams.get("code");
  const navigate = useNavigate();

  useEffect(() => {
    const kakaoLogin = async () => {
      try {
        console.log("Authorization code:", code); // 인가 code 출력
        const res = await axios.get(
          `https://www.9dokme.p-e.kr/api/oauth?code=${code}`
        );

        console.log(res.data);
        // 로그인 시 message 추출
        const message = res.data.message;

        //message에서 닉네임, 이메일, 멤버아이디 추출
        const nicknameMatch = message.match(/nickname=([^,]*)/);
        const emailMatch = message.match(/email=([^,]*)/);
        const memberIdMatch = message.match(/memberId=([^}]*)/);

        // 추출한 값을 localStorage에 저장
        if (nicknameMatch && emailMatch) {
          const nickname = nicknameMatch[1];
          const email = emailMatch[1];
          const memberId = memberIdMatch[1];
          localStorage.setItem("name", nickname);
          localStorage.setItem("email", email);
          localStorage.setItem("memberId", memberId);
          //콘솔 출력으로 확인
          console.log("로컬스토리지 닉네임: ", localStorage.getItem("name"));
          console.log("로컬스토리지 이메일: ", localStorage.getItem("email"));
          console.log(
            "로컬스토리지 memberId: ",
            localStorage.getItem("memberId")
          );
        } else {
          console.error("Failed to parse nickname or email from message");
        }
        if (localStorage.getItem("memberId") !== "6") navigate("/mainPage");
        else navigate("/admin/adminPdf/");
      } catch (error) {
        console.error("Login failed:", error);
      }
    };

    if (code) {
      kakaoLogin();
    }
  }, [code, navigate]);

  return (
    <div className="w-screen h-screen flex items-center justify-center bg-customColor bg-opacity-20">
      <p className="text-xl font-semibold">로그인 중입니다 ...</p>
    </div>
  );
};

export default LoginLoading;
