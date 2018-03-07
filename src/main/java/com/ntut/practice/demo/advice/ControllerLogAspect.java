package com.ntut.practice.demo.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Aspect
@Component
public class ControllerLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);
    private static final ObjectMapper OM = new ObjectMapper();

    @Around("within(@org.springframework.stereotype.Controller *) && execution(public * com.ntut.practice.demo..*.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        String controller = pjp.getTarget().getClass().getSimpleName();
        String methodName = methodSignature.getName();
        String paramStr = getParamStr(pjp);
        if (StringUtils.isBlank(paramStr)) {
            paramStr = "none";
        }

        LOGGER.debug("Controller:{}, Method:{}, Params:{}", controller, methodName, paramStr);

        Object returnValue = pjp.proceed();
        String returnStr = getJsonDesc(returnValue);

        LOGGER.debug("Controller:{}, Method:{}, Return:{}", controller, methodName, returnStr);

        return returnValue;
    }

    private String getParamStr(ProceedingJoinPoint pjp) {
        Object[] requestParamArray = Optional.ofNullable(pjp.getArgs()).orElse(new Object[]{});
        return Arrays.stream(requestParamArray)
                .map(this::getJsonDesc)
                .collect(Collectors.joining(", "));
    }

    private String getJsonDesc(Object obj) {
        String className = obj.getClass().getSimpleName();
        String valueAsString = "";
        try {
            valueAsString = OM.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("Encountered an error when converted object to json , target:%s");
        }
        return String.format("[class:%s, value:%s]", className, valueAsString);
    }

}
