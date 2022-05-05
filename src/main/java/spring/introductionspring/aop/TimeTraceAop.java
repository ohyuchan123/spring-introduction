package spring.introductionspring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Objects;

@Aspect//AOP는 Aspect를 적어 줘야 됨
@Component //spring bin등록
public class TimeTraceAop {

    @Around("execution(* introductionspring..*(..))")
    public Object execut(ProceedingJoinPoint joinPoint) throws Throwable{
        Long start = System.currentTimeMillis();
        System.out.println("START : "+joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            Long finish = System.currentTimeMillis();
            Long timeMs = finish-start;

            System.out.println("END : "+joinPoint.toString()+" "+timeMs+"ms");
        }

    }
}
