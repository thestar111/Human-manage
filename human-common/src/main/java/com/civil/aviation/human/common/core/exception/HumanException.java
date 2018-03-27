/**
 * 文 件 名:  HumanException
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.common.core.exception;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HumanException extends RuntimeException
{
	/**
	 * 响应结果码
	 */
	private String resultCode;

	/**
	 * 响应结果消息
	 */
	private String resultMessage;

	/**
	 * Constructs a new runtime exception with {@code null} as its
	 * detail message.  The cause is not initialized, and may subsequently be
	 * initialized by a call to {@link #initCause}.
	 */
	public HumanException ()
	{

	}

	/**
	 * Constructs a new runtime exception with {@code null} as its
	 * detail message.  The cause is not initialized, and may subsequently be
	 * initialized by a call to {@link #initCause}.
	 */
	public HumanException (String resultCode, String resultMessage)
	{
		super (resultMessage);
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	/**
	 * Constructs a new runtime exception with the specified detail message and
	 * cause.  <p>Note that the detail message associated with
	 * {@code cause} is <i>not</i> automatically incorporated in
	 * this runtime exception's detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval
	 *                by the {@link #getMessage()} method).
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method).  (A <tt>null</tt> value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.)
	 * @since 1.4
	 */
	public HumanException (String message, Throwable cause)
	{
		super (message, cause);
		this.resultMessage = message;
	}

	/**
	 * Constructs a new runtime exception with the specified detail message and
	 * cause.  <p>Note that the detail message associated with
	 * {@code cause} is <i>not</i> automatically incorporated in
	 * this runtime exception's detail message.
	 *
	 * @param resultMessage the detail message (which is saved for later retrieval
	 *                      by the {@link #getMessage()} method).
	 * @param cause         the cause (which is saved for later retrieval by the
	 *                      {@link #getCause()} method).  (A <tt>null</tt> value is
	 *                      permitted, and indicates that the cause is nonexistent or
	 *                      unknown.)
	 * @since 1.4
	 */
	public HumanException (String resultMessage, String resultCode, Throwable cause)
	{
		super (resultMessage, cause);
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	public String getResultCode ()
	{
		return resultCode;
	}

	public void setResultCode (String resultCode)
	{
		this.resultCode = resultCode;
	}

	public String getResultMessage ()
	{
		return resultMessage;
	}

	public void setResultMessage (String resultMessage)
	{
		this.resultMessage = resultMessage;
	}

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("HumanException{");
		sb.append ("resultCode='").append (resultCode).append ('\'');
		sb.append (", resultMessage='").append (resultMessage).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}

	/**
	 * Creates a localized description of this throwable.
	 * Subclasses may override this method in order to produce a
	 * locale-specific message.  For subclasses that do not override this
	 * method, the default implementation returns the same result as
	 * {@code getMessage()}.
	 *
	 * @return The localized description of this throwable.
	 * @since JDK1.1
	 */
	@Override
	public String getLocalizedMessage ()
	{
		return super.getLocalizedMessage () + "Detail : " + this.toString ();
	}
}
