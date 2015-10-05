<form action="<c:url value="/produtos"/>" method="POST">
    <fieldset>
        <legend>Adicionar produtos</legend>

        <label for="nome">Nome:</label>
        <input id="nome" type="text" name="produto.nome" value="${produto.nome }"/>

        <label for="descricao">Descri��o:</label>
        <textarea id="descricao" name="produto.descricao">${produto.descricao }</textarea>

        <label for="preco">Pre�o:</label>
        <input id="preco" type="text" name="produto.preco" value="${produto.preco }"/>

        <button type="submit">Enviar</button>
    </fieldset>
</form>

<script type="text/javascript">
    $('#produtosForm').validate({
        rules: {
            "produto.nome": {
                required: true,
                minlength: 3
            },
            "produto.descricao": {
                required: true,
                maxlength: 40
            },
            "produto.preco": {
                min: 0.0
            }
        }
    });
</script>
