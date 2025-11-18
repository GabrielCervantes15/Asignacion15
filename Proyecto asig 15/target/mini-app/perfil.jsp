<jsp:include page="header.jspf" />

<%
    String usuario = (String) session.getAttribute("usuario");
%>

<h2>Bienvenido, <%= usuario %></h2>
<p>Esta es tu página de perfil privada.</p>

<a href="${pageContext.request.contextPath}/login?action=logout">Cerrar Sesión</a>

<hr>

<h3>Subir foto de perfil</h3>

<%
    String mensaje = (String) session.getAttribute("message");
    if (mensaje != null) {
%>
    <p><%= mensaje %></p>
<%
        session.removeAttribute("message");
    }
%>

<form action="${pageContext.request.contextPath}/upload" method="POST" enctype="multipart/form-data">
    <div>
        <label for="file">Selecciona una imagen:</label>
        <input type="file" id="file" name="file" accept="image/*" required>
    </div>
    <button type="submit">Subir Imagen</button>
</form>

<jsp:include page="footer.jspf" />