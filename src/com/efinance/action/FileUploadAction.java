package com.efinance.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.utils.ImageNameUtil;
import com.utils.OperateImage;
	
public class FileUploadAction extends ActionSupport implements ServletRequestAware{
	/**
	 *@author island
	 *@date 2011-08-13
	 */
	private static final long serialVersionUID = 1L;
		private File upload;
		private String uploadContentType;
		private String uploadFileName;
		private String savePath;
		FileInputStream inputStream;
		protected HttpServletRequest request;
		
		public void setServletRequest(HttpServletRequest request) {
			this.request = request;
			
		}
		public String upload()
		{
			byte[] buffer=new byte[1024];
			try
			{
				InputStream in=new FileInputStream(upload);
				//�ϴ�������Ҫ��,���ܰ����û��ϴ������ֵ�����
//				String realPath =   
				System.out.println(this.getSavePath()+"\\"+uploadFileName);
//			            ServletActionContext.getServletContext().getRealPath("/images"); 
				OutputStream out=new FileOutputStream(new File(this.getSavePath()+"\\"+uploadFileName));
			
				int length=in.read(buffer);
			while(length>0)
			{
				out.write(buffer);
				length=in.read(buffer);
			}
			
			in.close();
			out.flush();
			out.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return this.SUCCESS;
		}
		public String download()
		{
			//�Ժ�uploadFileName��Դ�����ݿ�
			File file=new File(this.getSavePath()+"\\"+uploadFileName);
			try {
				inputStream=new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			return "downImg";
		}
		
		public String cut() throws IOException{
			//x1,y1�͹�����  �������ǰ�˷Ŵ����Ǹ����п�,x1��y1�ǲ��ܿ���סͼƬ��С����Ҫ����x2��y2���ܿ���ס
			String x1 = request.getParameter("x1");
			String x2 = request.getParameter("x2");
			String y1 = request.getParameter("y1");
			String y2 = request.getParameter("y2");
			String width = request.getParameter("width");
			String height = request.getParameter("height");
			String hidimg = request.getParameter("hidimg");//��ȡͼƬ���ƣ�jsp�����ֺ�����Դ�����ݿ�
			OperateImage o = new OperateImage(Integer.parseInt(x1),Integer.parseInt(y1),Integer.parseInt(width),Integer.parseInt(height));
			//��hidimgȡ��ͼƬ����
			hidimg=hidimg.trim();
			hidimg=hidimg.substring(hidimg.lastIndexOf("/")+1);
			System.out.println(""+hidimg);
			o.setSrcpath(this.getSavePath()+"\\"+hidimg);  //Դ�ļ�·��
//			��ȡ�������洢·��
/*			String realPath =   
			            ServletActionContext.getServletContext().getRealPath("/images");  */
	        o.setSubpath(this.getSavePath()+"\\_"+ImageNameUtil.uploadFileName);	//Ŀ��·��   ͼƬ������Ҫ��
	        o.cut();
			return "cut";
		}
		
		public String getSavePath() {
			return ServletActionContext.getRequest().getRealPath(savePath);
		}
		public void setSavePath(String savePath) {
			this.savePath = savePath;
		}

		public FileInputStream getInputStream() {
			return inputStream;
		}
		public void setInputStream(FileInputStream inputStream) {
			this.inputStream = inputStream;
		}
		public File getUpload() {
			return upload;
		}
		public void setUpload(File upload) {
			this.upload = upload;
		}
		public String getUploadContentType() {
			return uploadContentType;
		}
		public void setUploadContentType(String uploadContentType) {
			this.uploadContentType = uploadContentType;
		}
		public String getUploadFileName() {
			return uploadFileName;
		}
		public void setUploadFileName(String uploadFileName) {
			uploadFileName=uploadFileName.trim();
			System.out.println(""+uploadFileName);			
			this.uploadFileName=uploadFileName.substring(uploadFileName.lastIndexOf("/")+1);
			ImageNameUtil.uploadFileName=uploadFileName.substring(uploadFileName.lastIndexOf("/")+1);
		}
//		 public void addActionError(String anErrorMessage){
//			   String s=anErrorMessage;
//			   System.out.println(s);
//			  }
//		  public void addActionMessage(String aMessage){
//		   String s=aMessage;
//		   System.out.println(s);
//		 
//		  }
//		  public void addFieldError(String fieldName, String errorMessage){
//		   String s=errorMessage;
//		   String f=fieldName;
//		   System.out.println(s);
//		   System.out.println(f);
//		  }
		
		
}
