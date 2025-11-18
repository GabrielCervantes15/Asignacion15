<jsp:include page="header.jspf" />

<h2>Iniciar Sesión</h2>

<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <p><%= error %></p>
<%
    }
%>

<form action="${pageContext.request.contextPath}/login" method="POST">
    <div>
        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" required>
    </div>
    <div>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <button type="submit">Entrar</button>
</form>

<jsp:include page="footer.jspf" />