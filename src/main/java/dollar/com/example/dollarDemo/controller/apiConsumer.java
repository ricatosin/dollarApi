package dollar.com.example.dollarDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;
@ResponseBody
@RestController
public class apiConsumer {
  @Autowired
  RestTemplate restTemplate;
  @RequestMapping("/api/getdollar/{date}")
  public Serializable getDollarByDate(@PathVariable("date") String date) {

    String DataUrl = "";
    String url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='"+date+"'&$format=json";

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    HttpEntity<String> entity = new HttpEntity<String>(headers);

    ResponseEntity<String> response = restTemplate.exchange(
        url,
        HttpMethod.GET,
        entity,
        String.class
    );

    if (response.getStatusCode() == HttpStatus.OK) {
      System.out.println("Request Successful.");
      return(response.getBody());
    } else {
      System.out.println("Request Failed");
      return(response.getStatusCode());
    }
  }
}