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

    private static final String pointCutStr = "execution(* fr.ensai..*(..)) || this(org.springframework.data.repository.CrudRepository+) && execution(* *(..))";

    private static int nbIdent = 0;

    /**
     * Log before method execution
     */
    @Before(pointCutStr)
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        Logger log = LoggerFactory.getLogger(className);

        String argsStr = "";
        if (args != null && args.length > 0) {
            argsStr = Arrays.stream(args)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            if (argsStr.length() > 100) {
                argsStr = argsStr.substring(0, 100) + "...";
            }
        }

        methodName += "(" + argsStr + ")";
        log.info("{} - BEGIN", " ".repeat(nbIdent * 4) + methodName);
        nbIdent++;
    }

    /**
     * Log after method execution
     */
    @AfterReturning(pointcut = pointCutStr, returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        Logger log = LoggerFactory.getLogger(className);

        nbIdent--;

        String argsStr = "";
        if (args != null && args.length > 0) {
            argsStr = Arrays.stream(args)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            if (argsStr.length() > 100) {
                argsStr = argsStr.substring(0, 100) + "...";
            }
        }
        methodName += "(" + argsStr + ")";

        if (result != null) {
            String resultStr = String.valueOf(result);
            if (resultStr.length() > 100) {
                resultStr = resultStr.substring(0, 100) + "...";
            }

            log.info(" ".repeat(nbIdent * 4) + "  └─> Output: {}", resultStr);
        }

        log.info("{} - END", " ".repeat(nbIdent * 4) + methodName);
    }
}
