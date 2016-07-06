package cn.com.chengzi.framework.common.valdation;

import javax.validation.Payload;

public @interface NotEmpty {
    String message() default "nto_empty";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
