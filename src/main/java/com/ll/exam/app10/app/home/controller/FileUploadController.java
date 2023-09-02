package com.ll.exam.app10.app.home.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
  @Value("${custom.genFileDirPath}") // value를 쓰게 되면 yml에 입력한 값이 여기 들어온다.
  private String genFileDirPath;

  @RequestMapping("")
  @ResponseBody
  public String upload(@RequestParam("img1") MultipartFile img1, @RequestParam("img2") MultipartFile img2) {
    // File file = new File("c:/test/app10/1.png");

    // transferTo 에서 exception이 나기에 try~catch로 감싸야 함.
    try {
      img1.transferTo(new File(genFileDirPath + "/1.png"));
      img2.transferTo(new File(genFileDirPath + "/2.png"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return "업로드 완료!";
  }
}
