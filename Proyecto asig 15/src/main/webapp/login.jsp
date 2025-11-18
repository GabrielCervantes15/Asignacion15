<jsp:include page="header.jspf" />
<h2>Iniciar Sesión</h2>
<%
String error = (String) request.getAttribute("error");
if (error != null) { %>
<p style='color:red'><%=error%></p>
<% } %>
<form action="login" method="POST">
<label>Usuario:<input type="text" name="usuario" required></label>
<label>Contraseña:<input type="password" name="password" required></label>
<button type="submit">Entrar</button>
</form>
<jsp:include page="footer.jspf" />
