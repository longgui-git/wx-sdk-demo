package cn.trawe.operation.base.third.common.utils;


public class TraweServiceException extends Exception{

	private static final long serialVersionUID = 1L;

	public TraweServiceException(String msg) {
        super(msg);
    }
    
    public TraweServiceException(String msg, Exception e) {
        super(msg, e);
    }
    
    public TraweServiceException(Exception e) {
        super(e);
    }
}
