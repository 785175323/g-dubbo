package com.kakuiwong.dubbo.config;


import com.kakuiwong.model.dto.GException;
import com.kakuiwong.model.dto.ResultCodeEnum;
import com.kakuiwong.model.dto.ResultDTO;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author: gaoyang
 * @Description:
 */
@Activate(group = {CommonConstants.PROVIDER}, order = Integer.MIN_VALUE)
public class GDubboExceptionFilter implements Filter, Filter.Listener {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("invoke");
        Result invoke = invoker.invoke(invocation);
        Throwable exception = invoke.getException();
        return invoke;
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
        if (appResponse.hasException() && GenericService.class != invoker.getInterface()) {
            try {
                Throwable exception = appResponse.getException();
                //如果是自定义异常则转换
                if (exception instanceof GException) {
                    exception = (GException) exception;
                    appResponse.setValue(new ResultDTO(ResultCodeEnum.EXCEPTION.getCode(), null,
                            ((GException) exception).getMsg(), null));
                    appResponse.setException(null);
                }
            } catch (Throwable e) {
                System.out.println("Fail to ExceptionFilter when called by " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName() + ": " + e.getMessage());
            }
        }
    }

    @Override
    public void onError(Throwable e, Invoker<?> invoker, Invocation invocation) {
        System.out.println("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName() + ": " + e.getMessage());
    }
}
