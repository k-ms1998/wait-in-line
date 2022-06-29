package fastcampus.GetInLine.controller.viewController;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController implements ErrorController {

    @GetMapping("/")
    public String root() {
        return "index"; // index 페이지
    }

    @RequestMapping("/error") // GET 말고도 모든 Request에 대한 error를 여기로 redirect
    public String error() {
        /**
         * Spring은 에러가 생기면 기본적으로 자체적인 /error으로 redirect해서 Whitelabel 페이지를 띄움
         * But, 개발자가 구현한 Controller가 ErrorController 인터페이스를 implement 하고 있으면 개발자가 그 주도권을 가져옴
         * 그러므로, /error 페이지로 자동으로 redirect 됐을떄 Whitelabel 페이지 대신 개발자가 원하는 error 페이지를 랜더링 할 수 있음
         *
         * ex:
         * localhost:8080/thisIsACollectionOfLettersDesignedToReturnAnError-djnaskdnaskjdn
         *
         * w/ implements ErrorController
         * error.html 랜더링
         *
         * w/o implements ErrorController
         * Whitelabel 랜더링
         */
        return "error";
    }
}
