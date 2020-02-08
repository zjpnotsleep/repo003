package com.leyou.order.web;

import com.leyou.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("wxpay")
public class NotifyController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "notify",produces = "application/xml")
    public Map<String,String> handler(@RequestBody Map<String,String> result){
        orderService.handlerNotify(result);

        log.info("[支付回调] 接收微信支付回调,结果：{}",result);
        Map<String,String> msg = new HashMap();
        msg.put("return_code","SUCCESS");
        msg.put("return_msg","OK");
        return msg;
    }
}
