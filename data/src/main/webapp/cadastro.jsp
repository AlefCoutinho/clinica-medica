<%--
Document : cadastro
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Nova tarefa</h1>
        <fieldset>
            <legend>USUER</legend>
            <form action="/login" method="post">
                <ul>
                    <li>
                        <label for="usuario">usuario</label>
                        <input id="usuario" type="text" name="usuario"/>
                    </li>
                   
                <input type="submit" value="Salvar" />
            </form>
        </fieldset>
    </body>
</html>