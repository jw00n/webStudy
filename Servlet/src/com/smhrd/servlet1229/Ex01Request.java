package com.smhrd.servlet1229;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//url ���� : ���ڿ��� servlet�� �����ϴ� ��� 
//servlet ������ �̸��� �������� �ʾƵ� ���ᰡ��
//���� ) '/'/�� �ݵ�� �տ� �ۼ��Ǿ� �־����. x? -> http404 dhfv q

@WebServlet("/TestWebPage")
public class Ex01Request extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request(��û��ü) : Ŭ���̾�Ʈ�� ��û�� ���� ��, ������� ������ �����ϴ� ��ü
		// ���� : IP, ������ ����(����, ���, ���ڵ� ��� ���..),

		// ����� ip �˾Ƴ���!

		String ip = request.getRemoteAddr();

		System.out.println("������ ip>>>" + ip);
		

		// ip�� Ȯ���Ͽ� �ٸ� ��¹��� �������� �����Ͻÿ�.
		// ���� �Ǵ� ¦�� ���ӽ� 00�� ȯ���մϴ�.
		// ���� ���� �� : ����� ȯ���մϴ�.
		// �̿� ���� �� : �մ� ȯ���մϵ�.
		// ipȮ���� ���ڿ� �� �޼ҵ带 Ȱ���Ұ�

		ArrayList<String> iplist = new ArrayList<>();

		iplist.add("121.147.52.44"); // �����
		iplist.add("220.93.229.228"); // �赵��
		iplist.add("220.80.165.69");// �㼺��
		iplist.add("220.80.165.32"); // �����
		boolean flag=false;
		for(int i=0; i<iplist.size(); i++) {
			if (ip.equals(iplist.get(i))) {
			flag=true;
			}
		}
		
		if (flag) {
			System.out.println("�����Դϴ�.");
		}
		else {
			System.out.println("�ƴմϴ�.");
		}

	}

}