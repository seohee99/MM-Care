package com.service.spring.controller;

import com.service.spring.service.CareService;
import com.service.spring.service.EatService;
import com.service.spring.service.MedicineService;
import com.service.spring.service.PoopService;
import com.service.spring.vo.Eat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/care")
@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:9999" }, allowCredentials = "true")
public class CareController {

    @Autowired
    private CareService careService;
    @Autowired
    private EatService eatService;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private PoopService poopService;


    @PostMapping("/food/add")
    public ResponseEntity<String> addFoodCnt(@RequestBody Eat eat){
        try {
            System.out.println("식사 컨트롤러 진입 성공" + eat.getPetSeq());

            // 파라미터 잘 받았는지 확인
            System.out.println(eat);

            // 로직 진입 전
            System.out.println("로직 진입 전");
            eatService.checkEat(eat);
            System.out.println("로직 진입 후");

            // 리엑트로 응답하기
            System.out.println("식사 체크 성공...");
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            // 실패 시 응답 (예: BadRequest)
            System.out.println("식사 체크 추가 실패...");
            return ResponseEntity.badRequest().body("식사 체크 추가 실패...");
        }
    }

    @GetMapping(value = "/food/list")
    public ResponseEntity<String> getFoodCnt(@RequestBody Eat eat){
        try {
            System.out.println("식사 컨트롤러 진입 성공" + eat.getPetSeq());

            // 파라미터 잘 받았는지 확인
            System.out.println(eat);

            // 로직 진입 전
            System.out.println("로직 진입 전");
            eatService.showCheckList(eat);
            System.out.println("로직 진입 후");

            // 리엑트로 응답하기
            System.out.println("식사 체크 성공...");
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            // 실패 시 응답 (예: BadRequest)
            System.out.println("식사 체크 추가 실패...");
            return ResponseEntity.badRequest().body("식사 체크 추가 실패...");
        }
    }



}
