/**
 * 文 件 名:  GzipInterceptor
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.handler;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * <启用GIP压缩服务>
 *
 * @author zping
 * @version 2018/3/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Provider
public class GzipInterceptor implements WriterInterceptor
{

	private static final String CONTENT_ENCOD = "gzip";

	private static final String CONTENT_ENCODING = "Content-Encoding";

	/**
	 * 机器名称
	 */
	private static final String MACHINE = "machine";

	@Override
	public void aroundWriteTo (WriterInterceptorContext context) throws IOException, WebApplicationException
	{
		MultivaluedMap<String, Object> headers = context.getHeaders ();
		headers.add (CONTENT_ENCODING, CONTENT_ENCOD);
		/*解决乱码问题*/
		final OutputStream outputStream = context.getOutputStream ();
		context.setOutputStream (new GZIPOutputStream (outputStream));
		context.proceed ();
	}
}
