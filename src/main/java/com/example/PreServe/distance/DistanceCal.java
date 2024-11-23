package com.example.PreServe.distance;

import org.springframework.http.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * 파트너store 주소와 유저 주소를 정보를 지도api 이용한 거리 계산
 */
public class DistanceCal {

 /*   *//**
     * 경위도 정보로 주소를 불러오는 메소드
     *
     *//*
    public static String coordToAddr(String longitude, String latitude){
        String url = "https://dapi.kakao.com/v2/local/geo/coord2address.json?x="+longitude+"&y="+latitude;
        String addr = "서울특별시 구로구 천왕로21";
        try{
            addr = getRegionAddress(getJSONData(url));
            //LOGGER.info(addr);
        }catch(Exception e){
            System.out.println("주소 api 요청 에러");
            e.printStackTrace();
        }
        return addr;
    }

    *//**
     * REST API로 통신하여 받은 JSON형태의 데이터를 String으로 받아오는 메소드
     *//*
    private static String getJSONData(String apiUrl) throws Exception {
        HttpURLConnection conn = null;
        StringBuffer response = new StringBuffer();

        //인증키 - KakaoAK하고 한 칸 띄워주셔야해요!
        String auth = "5e4890f4441fe723d54c9057602bef48 " + "2ecf5febe1e05d5d376370e2b4d6c779";

        //URL 설정
        URL url = new URL(apiUrl);

        conn = (HttpURLConnection) url.openConnection();

        //Request 형식 설정
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-Requested-With", "curl");
        conn.setRequestProperty("Authorization", auth);

        //request에 JSON data 준비
        conn.setDoOutput(true);

        //보내고 결과값 받기
        int responseCode = conn.getResponseCode();
        if (responseCode == 400) {
            System.out.println("400:: 해당 명령을 실행할 수 없음");
        } else if (responseCode == 401) {
            System.out.println("401:: Authorization가 잘못됨");
        } else if (responseCode == 500) {
            System.out.println("500:: 서버 에러, 문의 필요");
        } else { // 성공 후 응답 JSON 데이터받기

            Charset charset = Charset.forName("UTF-8");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
        }

        return response.toString();
    }

    *//**
     * JSON형태의 String 데이터에서 주소값(address_name)만 받아오기
     *//*
    private static String getRegionAddress(String jsonString) {
        String value = "";
        JSONObject jObj = (JSONObject) JSONValue.parse(jsonString);
        JSONObject meta = (JSONObject) jObj.get("meta");
        long size = (long) meta.get("total_count");

        if(size>0){
            JSONArray jArray = (JSONArray) jObj.get("documents");
            JSONObject subJobj = (JSONObject) jArray.get(0);
            JSONObject roadAddress =  (JSONObject) subJobj.get("road_address");

            if(roadAddress == null){
                JSONObject subsubJobj = (JSONObject) subJobj.get("address");
                value = (String) subsubJobj.get("address_name");
            }else{
                value = (String) roadAddress.get("address_name");
            }

            if(value.equals("") || value==null){
                subJobj = (JSONObject) jArray.get(1);
                subJobj = (JSONObject) subJobj.get("address");
                value =(String) subJobj.get("address_name");
            }
        }
        return value;
    }
*/
    public static String getApiByAddress() {
        String appkey = "KakaoAK 2ecf5febe1e05d5d376370e2b4d6c779";
        final String apiKey = "2ecf5febe1e05d5d376370e2b4d6c779";
        String KakaoAK = "5e4890f4441fe723d54c9057602bef48 ";
        //String apiUrl = "https://dapi.kakao.com/v2/local/geo/transcoord.json?x=160710.37729270622&y=-4388.879299157299&input_coord=WTM&output_coord=WGS84";
        String city = "서울특별시 구로구 천왕로21";
        String encode = null;
        try {
            encode = URLEncoder.encode(city,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        try {
            //string -> URL 형식 바꿔주기
            String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json?query="+encode;
            URL url = new URL(apiUrl);
            //apiURL 을 HTTP형식으로 연결함 . 요청을 보낼수있는 HttpURLConnection을 연다
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //get요청을 보냄
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization",appkey);
            connection.setDoOutput(true);

            //응답결과
            int responseCode = connection.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                //응답결과 br에 넣음 br를 쓰면 속도 및 성능향상..
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            String inputLine;
            //stringBuilder에다가 결과 쌓기
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();


            return response.toString();
        } catch (Exception e) {
            return "failed to get response";
        }
    }

    public static String serachByCustomerLoc() {
        String appkey = "KakaoAK 2ecf5febe1e05d5d376370e2b4d6c779";
        final String apiKey = "2ecf5febe1e05d5d376370e2b4d6c779";
        String KakaoAK = "5e4890f4441fe723d54c9057602bef48 ";
        //String apiUrl = "https://dapi.kakao.com/v2/local/geo/transcoord.json?x=160710.37729270622?y=-4388.879299157299&input_coord=WTM&output_coord=WGS84";
        String encode = null;
        String keyword = "쌀국수";
        String x="126.838929498352";
        String y="37.4791754743291";

        try {
            encode = URLEncoder.encode(keyword,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        try {
            //string -> URL 형식 바꿔주기
            String apiUrl = "https://dapi.kakao.com/v2/local/search/keyword.json?y="+y+"&x="+x+"&radius=20000&query="+encode;
            //String apiUrl = "https://dapi.kakao.com/v2/local/search/keyword.json?y=37.514322572335935&x=127.06283102249932&radius=20000&query="+encode;
            URL url = new URL(apiUrl);
            //apiURL 을 HTTP형식으로 연결함 . 요청을 보낼수있는 HttpURLConnection을 연다
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //get요청을 보냄
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization",appkey);
            connection.setDoOutput(true);

            //응답결과
            int responseCode = connection.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                //응답결과 br에 넣음 br를 쓰면 속도 및 성능향상..
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            String inputLine;
            //stringBuilder에다가 결과 쌓기
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();


            return response.toString();
        } catch (Exception e) {
            return "failed to get response";
        }



    }


}
