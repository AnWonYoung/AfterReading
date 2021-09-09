package com.wonyoung.afterreading.user;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class UserService {
// 휴대폰 인증 서비스
    public void certifiedPhoneNumber(String phoneNumber, String cerNum) {

        String api_key = "비밀";
        String api_secret = "비밀";
        Message coolsms = new Message(api_key, api_secret);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);    // 수신자
        params.put("from", phoneNumber);    // 발신자 (테스트는 수신자로 우선 설정)
        params.put("type", "SMS");
        params.put("text", "After Reading 회원가입 인증번호 : " + "["+cerNum+"]" + "-원영-");
        params.put("app_version", "test app 1.2");

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

    }

    public String sendSMS(String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

//        System.out.println("수신자 번호 : " + phoneNumber);
//        System.out.println("인증번호 : " + numStr);
        certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }

}
