package com.nf.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.nf.service.port.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: LJP
 * @Classname ApyController
 * @Date: 2020-02-08 16:11
 * @Description: 支付控制器
 */
@Controller
public class ApyController {
    @Autowired
    private ProductOrderService productOrderService;

    private final String APP_ID = "2016101600697713";
    private final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDHlgrubwusq6nv/nltmAN+MDtl6Rs4EH7X3A1C88vT4mxZ76ZRsy/ow9i0KnMc0Q3/HcW+CLd2jY6dS/RBc+q3/7Yy9QOG+zxiM0/BiIAr49vVSdwk6ZDWOECk7cAnhRtscHchO2OplVyhAAdAkJXdiLBsYrUd1eG9pgZmabsmLdfDouMVqSre2HhZrc90BdfoNjjtaWbGugdrpxtPecxs132d9CYQKR2Sx/O227H8uppku+3rtCqNEwfD6tA3s0RpjLX8SKwgoA3AmCSTkMsbZpBKIW3aSmdwyJEYTxKFJQ0RsMzaoW3iwv5oxVQJXd6UncVEWF0xMXKCggK6eIzrAgMBAAECggEAeY0GoUmd2Y4+k7vuZfFjhzGGqz05Z36cUYhhxznFFAjcpjVOnIk9j0vfKXKE4rLrDEksidyzJw91IJUGb+pRs7eXVhdkC4vsrX3EgABK1vARjSdLXGum2uAtdoSZNzhYiEVCOEn8G2asoBztTcQAkYfSsl+3IDGHJsH7OdoAsXG8Uu1UJI+3efrbYzMIskKQ32/pM5ZzjIksKoj5UwSJDCMxrLHt4Px8/ZTdhLfIpGOtggdca3m3G0yCtOH7JwXGCihRUbsYTd2R+QvmBrTaDSwn10r5AuRcSqUOorpygAmS6DFsihMyYeIAjO4mxzKplJtPskZ7fa2Ssvhyp018IQKBgQDsNvi/YWG1NvybJC7cpkVqQpNNPWJX13CKM2ZhXjdsY29Kh7GZJAxiR36DXitSwQ/kDi5Z1Nnz60iiXxkMRQeyXYGzJ+cz+knGjMBbak/6qNMAXyTQqnkZOaZHpJcNQo+c0P5Ismefzp9plD+pTeSjer3vxuO6mWWGMPh/Q/CW0QKBgQDYTamgO1UJpY99p1Cty0zDwrzmQ746IFe+K1WQ8CaLapiYEaNW9/0PRyT2Sqjidh14qDJyOYM0VfESeMTPG7G9hXADz4XRJMDq4fAGDSKczWJAa6iBhJNYeKMqwz0LXpYp4wNXE6HeT9ZrND1LNQWBYIMKmAO+o9+mZyhbf9FO+wKBgQDETBJ/CDAoZd+aFYGT/+DjoxvCLmbRVMnDL1+/PoqUWjWcHBOsjdZ0vbEW/mTGSoYoINjH8iiFmVstBBZOqfbxdN9ZwKlT+oTgqQsZbMm2JiHixy5S8bfdDJlwJAkbDdtGmC8Yvpl6pjy3gmk9CuwcJt48qm2JHfzOfVekexMuYQKBgDRGuMs367p0H/TPXilSrA/X3c2M68mijXIxiPGJiNdDAPQntyFKuAdcO2um6aApyb+ibua6TaJ1btj3BSHE4LUcLdFN81pzloht6JOd0xKwdKF7I3OB9hZ4uX6ZRwSbbJFdAy6lWQagpwKr0nB9tQHqsGD8ElOdyWyvG8rZXl3HAoGBAIqoNieGFQQfPVXHPGfKKV8QMfszYe+h3r820E6Egdk1G/pYrfwftHoNJvYD/dCtt94vgPgFLu1dhrQhWQ2xy7420G+BuD4TtGAy7snpfTVaPzoOVOyCBUPLb4j1K/TT5ubcOuYz60jI/Nrq97X7km5kalJlsXMpKnfuZ6TduBIr";
    private final String CHARSET = "UTF-8";
    //这个是支付宝公匙，不是应用公匙！！！
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwDVA6UvALbmZ6xi0hh5r0fNnuA6yxa+jLUwyJpKsXvel/cIMKNBm4WJBlu3c5RxmCJ/9RgfxN3NAUh8JZMNinHOf0Wkx3wsv1JtbaxHoHKJGQM5P3KnqxZKC9Nn2JJdujNpMMsAx0AcLRIXlFD/xXK7fGazJPnC75Blb2R8xCA99soxfZs1+nO8Vw4yYLVJzxkaVmermTMlnnbZrdhVkDbZhcAoXXDStaSAXKFQMYnjhwXPK5iFO1TWxg6zRVApedziAGcwS4JUr47jzGY86qMovtbwjedrlVASRtPQ17KI5Kqfm1YS9sH0OdsT57GFo+LKvgOFqaQv3ggCbN/tz1wIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://localhost:8080/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8080/returnUrl";
    private String orderNumber = "";

    @RequestMapping("/alipay")
    public void alipay(String productOrderNumber, String productPrice, String productName, HttpServletResponse httpResponse) throws IOException {
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);
        //根据订单编号,查询订单相关信息
        //商户订单号，商户网站订单系统中唯一订单号，必填
        orderNumber = productOrderNumber;
        String out_trade_no = productOrderNumber;
        //付款金额，必填
        String total_amount = productPrice;
        //订单名称，必填
        String subject = productName;
        //商品描述，可空
        String body = "";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            // 调用SDK生成表单
            form = alipayClient.pageExecute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        // 直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = (Map<String, String[]>) request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
/*
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
*/
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
//验证签名通过
        System.out.println("signVerified = " + signVerified);
        if (signVerified) {
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号=" + out_trade_no);
            System.out.println("支付宝交易号=" + trade_no);
            System.out.println("付款金额=" + total_amount);

            //支付成功，修复支付状态
            //跳转付款成功页面
            return "forward:ok";
        } else {
            //跳转付款失败页面
            return "forward:no";
        }
    }

    @RequestMapping("/ok")
    public String ok(){
        return productOrderService.paymentOrder(orderNumber) ? "forward:/mall/foreground/product/order/payment/success" : "forward:no";
    }

    @RequestMapping("/no")
    public String no(){
        return "forward:/mall/foreground/product/order/payment/loser";
    }
}
