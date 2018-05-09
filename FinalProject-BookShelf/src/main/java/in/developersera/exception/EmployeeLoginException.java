package in.developersera.exception;

public class EmployeeLoginException extends Exception{
	
	public EmployeeLoginException(String message)
	{
		super("EmployeeLoginException-"+message);
	}
	
	public EmployeeLoginException(String message, Throwable cause)
	{
		super("EmployeeLoginException-"+message,cause);
	}

}
