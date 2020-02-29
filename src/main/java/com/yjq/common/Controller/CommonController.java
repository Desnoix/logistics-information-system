package com.yjq.common.Controller;

import com.yjq.common.ResultEnum;
import com.yjq.common.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName CommonController
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/2/17 21:10
 * @Version 1.0
 */
@RestController
public class CommonController {

    @RequestMapping("/common/successLoginToJson")
    @ResponseBody
    public Map<String, Object> successToJson(HttpServletRequest request) {
        Map<String, Object> data = (Map<String, Object>) request.getAttribute("data");
        Map<String, Object> success = ResultVO.success( (String) data.get("token"));
        return success;
    }
    @RequestMapping("/common/failureToJson")
    @ResponseBody
    public Map<String, Object> failureToJson(HttpServletRequest request) {
        Map<String, Object> data = ResultVO.failure(ResultEnum.USER_LOGIN_FAILED.getCode(), ResultEnum.USER_LOGIN_FAILED.getMessage());
        return data;
    }
}
