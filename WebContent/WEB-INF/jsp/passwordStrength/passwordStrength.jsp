<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<div class="book-form">

		<legend>Verifique a for�a de sua senha</legend>

		<form method="post" action="passwordStrength" class="form-inline">
    		<label class="control-label" for="password_id">Senha</label>
			<div class="form-group has-feedback">
    			<input type="password" name="password.password" class="form-control" id="password_id" placeholder="${password.status}">
    			<span class="glyphicon form-control-feedback"></span>
  			</div>	
  			<button type="submit" class="btn btn-primary">Verificar</button>
  			
  			
  			<div>
  				</br>
  				Password: ${password.password}</br>
	  			Percentual Weak: ${password.weakWeight}</br>
	  			Percentual Medium: ${password.mediumWeight}</br>
	  			Percentual Strong: ${password.strongWeight}</br>
			</div>
  		</form>	
  		
	</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

<script type="text/javascript">
	$(function() {
				
		<c:choose>
        	<c:when test="${password.status eq 'Senha forte'}">
        		$(".form-group").addClass("has-success");
        		$(".glyphicon").addClass("glyphicon-ok");
        	</c:when>
        	<c:when test="${password.status eq 'Senha m�dia'}">
	        	$(".form-group").addClass("has-warning");
	    		$(".glyphicon").addClass("glyphicon-warning-sign");
        	</c:when>
        	<c:when test="${password.status eq 'Senha fraca'}">
        		$(".form-group").addClass("has-error");
    			$(".glyphicon").addClass("glyphicon-remove");
    		</c:when>
        </c:choose>
	});
</script>

</html>

