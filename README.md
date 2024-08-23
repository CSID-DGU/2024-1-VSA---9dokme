<div align="center">

<h1> 9DokMe </h1>

<img width="550px" src="https://github.com/CSID-DGU/2024-1-VSA-9dokme-T04/blob/develop/Data/books/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202024-08-23%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%201.32.09.png?raw=true"  alt="서비스대표-이미지" />
<div>대학생을 위한 전공책 PDF 구독 서비스</div>

</div>

<h2> ⭐️ Team </h2>

<table align="center">
    <tr align="center">
      <td style="min-width: 150px;">
            <a href="https://github.com/bbabbi">
              <img src="https://github.com/CSID-DGU/2024-1-VSA-9dokme-T04/blob/develop/Data/Github%20Profile/Chaeyoung%20Moon.jpeg?raw=true" width="200" alt="깃허브계정-프로필사진"/>
              <br />
              <b>Chaeyoung Moon</b>
            </a>
        </td>
      <td style="min-width: 150px;">
            <a href="https://github.com/rlaalsghks8">
              <img src="https://github.com/CSID-DGU/2024-1-VSA-9dokme-T04/blob/develop/Data/Github%20Profile/Minhwan%20Kim.jpeg?raw=true" width="200" alt="깃허브계정-프로필사진">
              <br />
              <b>rlaalsghks8</b>
            </a>
        </td>
      <td style="min-width: 150px;">
            <a href="https://github.com/chungchae">
              <img src="https://github.com/CSID-DGU/2024-1-VSA-9dokme-T04/blob/develop/Data/Github%20Profile/Heeseo%20Kim.jpeg?raw=true" width="200" alt="깃허브계정-프로필사진">
              <br />
              <b>Heeseo Kim</b>
            </a>
        </td>
      <td style="min-width: 150px;">
            <a href="https://github.com/seulgit02">
              <img src="https://github.com/CSID-DGU/2024-1-VSA-9dokme-T04/blob/develop/Data/Github%20Profile/Seulgi%20Baek.jpeg?raw=true" width="200" alt="깃허브계정-프로필사진">
              <br />
              <b>백슬기</b>
            </a>
        </td>
    </tr>
    <tr align="center">
       <td>
            문채영 <br/>
      </td>
       <td>
            김민환 <br/>
      </td>
       <td>
            김희서 <br/>
      </td>
       <td>
            백슬기 <br/>
      </td>
    </tr>
  	<tr align="center">
       <td>
            Team Leader, Backend Developer <br/>
      </td>
       <td>
            Backend Developer <br/>
      </td>
       <td>
            Backend & Frontend Developer <br/>
      </td>
       <td>
            Frontend Developer <br/>
      </td>
    </tr>
  	<tr align="center">
       <td>
            배포, 결제, 구독갱신, ChatGPT, 북마크, 관리자페이지 <br/>
      </td>
       <td>
            소셜로그인(카카오), 커뮤니티 게시판 API, 교재 검색 및 상세페이지 조회, PDF 웹뷰 조회, 관리자 페이지<br/>
      </td>
       <td>
            [FE] API 연동 <br/> [BE] 소셜로그인(카카오), 마이페이지, 커뮤니티 게시판, 관리자 페이지, 구독 갱신 <br/>
      </td>
       <td>
            웹 뷰 구현 및 퍼블리시, API 연동 <br/>
      </td>
    </tr>
</table>


<h2> ⭐️ 9DokMe 주요 기능 </h2>

<h3> 1️⃣ 교재 별 질문 커뮤니티 </h3>
<img src="https://github.com/CSID-DGU/2024-1-VSA-9dokme-T04/blob/develop/Data/books/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202024-08-23%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%201.32.09.png?raw=true"
alt="기능2-대표이미지" />
<div >
<br/>
<strong> 교재 열람 시 질문 커뮤니티 기능 사용 가능 </strong>   <br/>
- 사용자가 궁금한 Chapter,Page에 대한 질문글 업로드 가능 <br/>
- 다른 사용자들이 질문에 대해 댓글을 통해 답변 및 소통 가능 <br/>
- 질문 검색 기능에서 Chapter, page를 입력하여 같은 어려움을 겪고 있는 다른 사용자들의 질문들을  확인 가능
</div>

<h3> 2️⃣ 정기 결제 및 구독 갱신 </h3>
<img src="https://github.com/CSID-DGU/2024-1-VSA-9dokme-T04/blob/develop/Data/books/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202024-08-23%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%201.32.09.png?raw=true"
alt="기능2-대표이미지" />
<div >
<br/>
<strong> PG사 API 통합 구현 및 Spring Batch를 활용한 결제 및 구독 갱신  </strong>   <br/>
- 결제 구현 시, PG사의 API를 통합하여 구현 <br/>
- 사용자에게 다양한 결제 옵션 제공 가능 <br/>
- Spring Batch를 사용하여 자동 정기 결제 시스템 구현 <br/>
- 오전 10시를 기준으로 사용자의 결제 상태, 구독 만료일을 확인하여 사용자가 결제를 했을 경우 구독 만료일을 한 달 뒤로 갱신하여 DB에 저장 <br/>
- 사용자가 결제를 해지했을 경우 결제 상태를 미결제로 변경 후 구독 정보 갱신 <br/>
</div>

<h3> 3️⃣ ChatGPT를 활용한 챗봇 </h3>
<img src="https://github.com/CSID-DGU/2024-1-VSA-9dokme-T04/blob/develop/Data/books/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202024-08-23%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%201.32.09.png?raw=true"
  alt="기능3-대표이미지" />
<div >
<br/>
<strong> contents 접근성 향상  </strong>   <br/>
- 복잡한 개념이나 용어에 대한 설명을 요청할 때, 챗봇을 통한 즉각적인 정보 습득 가능
</div>

<h2> 🛠 기술스택 </h2>

|  **Category**   |              **Stack**              |
|:---------------:|:-----------------------------------:|
|   `Front-end`   | `React`, `JavaScript`, `TypeScript` |
|   `Back-end`    |        `SpringBoot`, `Java`         |
| `Data Fetching` |               `Axios`               |
|  `Deployment`   |           `Nginx`, `AWS`            |
|   `Database`    |            `MySQL(RDS)`             |
| `Collaboration` |    `Notion`, `Figma`, `Discord`     |

<br/>

<h2>  📄 컨벤션 및 브랜치 전략 </h2>

<br/>

<h3>  🖋️ 커밋 컨벤션 </h3>

|    **Type**     |             **Description**              |
|:---------------:|:----------------------------------------:|
|   `[CHORE]`   |   동작에 영향 없는 코드 or 변경 없는 변경사항(주석 추가 등)    |
|   `[FEAT]`    |                새로운 기능 구현                 |
| `[ADD]` | Feat 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 파일 생성 |
|  `[FIX]`   |                버그, 오류 해결                 |
|   `[DEL]`    |                쓸모없는 코드 삭제                |
| `[RENAME]` |          README나 WIKI 등의 문서 수정           |
| `[REFACTOR]` |                파일 이름 변경시                 |
| `[SETTING]` |                 프로젝트 세팅                  |

<br />

<h3>  🖋️ 브랜치 전략 </h3>

Git-Flow

**[브랜치명 예시]** <br />
`ex) feature/#3-login` <br />
어떤건지/#이슈번호-기능

<h2>  📁 폴더 구조 </h2>