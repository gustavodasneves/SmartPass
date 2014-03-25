<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<div class="container">
		<h3>Regras para uma senha forte:</h3>
		<h4>
			1 - Tamanho da senha - acima de 8 caracteres</br></br>
			2 - Tipos de caracteres - no m�nimo: 1 letra mai�scula, 1 letra min�scula, 1 d�gito num�rico, 1 sinal de pontua��o ou s�mbolo especial</br></br>
			3 - Dicion�rio - n�o consta no dicion�rio</br></br>
			4 - Sequ�ncias e repeti��es alfanum�ricas - cont�m sequ�ncia ou repeti��o de no m�ximo 2 caracteres em qualquer parte da senha</br></br>
			5 - Datas - n�o cont�m padr�o de data num�rico</br></br>
		</h4>
	</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />

