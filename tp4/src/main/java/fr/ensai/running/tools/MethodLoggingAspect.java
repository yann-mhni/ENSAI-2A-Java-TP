package fr.ensai.running.tools;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(MethodLoggingAspect.class);

    private static int nbIdent = 0;

    /**
     * Log before method execution
     */
    @Before("execution(* fr.ensai..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            String argsStr = Arrays.stream(args)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            if (argsStr.length() > 100) {
                argsStr = argsStr.substring(0, 100) + "...";
            }
            methodName = methodName.replace("(..)", "(" + argsStr + ")");
        }
        log.info("{} - BEGIN", " ".repeat(nbIdent * 4) + methodName);
        nbIdent++;
    }

    /**
     * Log after method execution
     */
    @AfterReturning(pointcut = "execution(* fr.ensai..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        nbIdent--;
        String methodName = joinPoint.getSignature().toShortString();

        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            String argsStr = Arrays.stream(args)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            if (argsStr.length() > 100) {
                argsStr = argsStr.substring(0, 100) + "...";
            }
            methodName = methodName.replace("(..)", "(" + argsStr + ")");
        }

        log.info("{} - END", " ".repeat(nbIdent * 4) + methodName);

        if (result != null) {
            String resultStr = String.valueOf(result);
            if (resultStr.length() > 100) {
                resultStr = resultStr.substring(0, 100) + "...";
            }

            log.info(" ".repeat(nbIdent * 4) + "  └─> Output: {}", resultStr);
        }
    }
}
