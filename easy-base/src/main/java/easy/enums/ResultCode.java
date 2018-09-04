package easy.enums;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/4 18:39
 * @Version: 1.0
 */
public enum ResultCode {

    SUCCESS("0000","请求成功");

    private String code;

    private String value;

    ResultCode(String code, String value) {
        this.code = code;
        this.value = value;
    }

}
