package com.example.server_9dokme.book.service;

import com.example.server_9dokme.book.dto.response.BarcodeInfoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AladinService {

    private static final String API_URL = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx";
    @Value("${aladin.api.key}")
    private String API_KEY;

    public BarcodeInfoResponse.Item getBarcodeInfoByISBN(String isbn) {
        try {
            // API URL 구성
            String url = API_URL + "?ttbkey=" + API_KEY
                    + "&itemIdType=ISBN"
                    + "&ItemId=" + isbn
                    + "&output=js"
                    + "&Version=20131101";

            // API 호출
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            // JSON 응답 매핑
            ObjectMapper objectMapper = new ObjectMapper();
            BarcodeInfoResponse bookInfoResponse = objectMapper.readValue(response, BarcodeInfoResponse.class);

            // 결과 반환
            if (bookInfoResponse.getItems() != null && bookInfoResponse.getItems().length > 0) {
                return bookInfoResponse.getItems()[0];
            } else {
                throw new RuntimeException("도서 정보를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            throw new RuntimeException("알라딘 API 호출 중 오류 발생: " + e.getMessage(), e);
        }
    }
}

