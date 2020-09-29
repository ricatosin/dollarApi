package dollar.com.example.dollarDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

  private String welcomeMessage = "Hello My Friend";
  private String goodBye = "GoodByeeeeee";

  //MAPPING URL localhost:8080/welcome to show message
  @RequestMapping("/welcome")
  public String welcome() {
    return welcomeMessage;
  }

  @RequestMapping("/bye")
  public String bye() {
    return goodBye;
  }

}
