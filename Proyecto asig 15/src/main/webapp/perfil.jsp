<jsp:include page="header.jspf" />
<%
String usuario = (String) session.getAttribute("usuario");
%>
<h2>Bienvenido, <%= usuario %></h2>
<a href="login?action=logout">Cerrar Sesión</a>
<h3>Subir foto</h3>
<form action="upload" method="POST" enctype="multipart/form-data">
<input type="file" name="file" required>
<button type="submit">Subir</button>
</form>
<%
String msg = (String) request.getAttribute("message");
if (msg != null) { %>
<p><%= msg %></p>
<% } %>
<jsp:include page="footer.jspf" />
