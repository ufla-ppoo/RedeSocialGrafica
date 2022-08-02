# Rede Social Gráfica

Este projeto de exemplo é usado para exercitar os conceitos de *GUI* (Interfaces Gráficas de Usuário) e Tratamentos de Exceção.

A implementação usa como base uma versão traduzida do exemplo do livro *Programacao Orientada a Objetos com Java - uma introducao pratica utilizando BlueJ*, de **Barnes e Kolling**.

## Sobre o Projeto

Em relação ao projeto de exemplo `RedeSocial`, usado anteriormente nas aulas de Polimorfismo, este projeto acrescenta:

- Uma interface chamada `Publicacao` que é implementada pela classe Mensagem.
- A implementação das operações de curtir e comentar uma mensagem.
- Uma classe chamada `TelaRedeSocial` que implementa a interface gráfica para a Rede Social.

## Exercícios - Parte 1 - Interfaces Gráficas

Faça os passos abaixo. Não esqueça de fazer `commit` e sincronizar as alterações após cada passo terminado.

### Passo 1.1

O botão `Comentar` não está fazendo nada. 
Faça as implementações necessárias para que ele passe a funcionar (veja o tratamento do botão `Curtir` como exemplo).

### Passo 1.2

Acrescente um botão `Atualizar` que atualize (recarregue) o Feed de Notícias.

### Passo 1.3

O Feed de Notícias da Rede Social tem tamanho fixo.
Se as mensagens não couberem na tela, elas simplesmente não aparecem.
Vamos melhorar isso colocando o componente que mostra o feed de notícias em um `JScrollPane` (um painel que mostra barras de rolagem quando necessário).

Para fazer isso, basta:
- Criar um `JScrollPane` passando o componente do feed como parâmetro do construtor.
- E então adicionar o `JScrollPane` na janela (ao invés do componente).

Teste sua implementação.

### Passo 1.4

Que tal mudarmos a fonte do nosso Feed de Notícias?

A classe `JTextArea` tem um método chamado `setFont` que muda a fonte utilizada.
Ele espera um objeto da classe `Font` que pode ser criado passando-se o nome da fonte, um estilo e o tamanho da fonte (ex: `new Font("Serif", Font.ITALIC, 16)`).

Teste sua implementação.

### Passo 1.5

Nossa Rede Social mostra no Feed de Notícias as mensagens de todos os autores. 
Suponha que precisemos de uma forma para encontrar mais facilmente as mensagens de um determinado autor.
Podemos, por exemplo, criar uma caixa de seleção para selecionar um autor e o Feed de Notícias mostrar apenas as mensagens daquele autor.
Para fazermos isso, vamos seguir os passos abaixo:

1. Altere a classe `FeedNoticias` para que ela tenha uma lista com os autores das mensagens.
   Toda vez que uma nova mensagem for adicionada, se o autor ainda não está na lista, ele é incluído.
   Crie também um método para retornar a lista com todos os autores (cuidado com o encapsulamento!).
   Faça as alterações necessárias e teste o programa.

2. Na classe `FeedNoticias`, crie uma sobrecarga do método `getPublicacoes` que recebe um autor por parâmetro e retorna  apenas as mensagens dele.
   Teste sua implementação.

3. Vamos agora acrescentar à nossa tela uma caixa para o usuário selecionar o autor das mensagens que ele quer ver.
   Uma caixa de  seleção é um objeto da classe `JComboBox`, que tem uma lista de objetos (cada objeto será uma opção na caixa de seleção).
   Vamos então:

    - Criar a caixa de seleção.
    - Colocar a caixa de seleção dentro de um painel que esteja na área superior (`NORTH`) do `BorderLayout`.
    - Criar um método que esvazia e preenche a caixa de seleção com os autores. 
      Para isso, use os métodos da classe `JComboBox`: `removeAllItems` e `addItem`.
      Você deve sempre adicionar primeiro a string `"Todos"` e depois cada um dos autores retornados pelo feed de Notícias.
      O método criado deve ser chamado tanto após a criação da caixa de seleção, como também toda vez que uma mensagem for postada.
    - Tratar o evento de clique da caixa de seleção da mesma forma que fazemos para os botões e atualizar o feed de notícias de acordo com o autor escolhido (dica: a classe `JComboBox` tem o método `getSelectedItem` que retorna o item selecionado).

Teste suas implementações.

### (Opcional) Passo 1.6

Vamos criar um menu com as opções: Postar Mensagem, Curtir, Comentar e Sair. 
Crie os menus e trate os eventos conforme necessário.

Dica: use os slides da aula de Interfaces Gráficas para ver exemplos de criação dos menus.

Teste sua implementação.

### (Opcional) Passo 1.7

Vamos agora fazer com que um menu popup apareça quando clicamos na área de texto do feed de notícias.
Para isso, você precisará tratar os eventos de mouse da área de texto (use `addMouseListener`).
No evento de clique do mouse você exibirá um menu popup criado conforme descrição abaixo.

O menu popup (classe `JPopupMenu`) funciona como um menu normal, ou seja, ele é formado por objetos do tipo `JMenuItem`.
Nosso menu popup deverá ter os ítems de menu: Atualizar e Limpar. 
O primeiro atualiza o feed (como o botão do Passo 1.2), já o segundo deve limpar o feed de notícias.

Obs: a classe `JPopupMenu` possui um método `show` que espera um componente e a posição x, y onde o menu deve aparecer (obtenha essas informações do objeto `MouseEvent`, que vem por parâmetro no tratamento do clique do mouse).

## Exercícios - Parte 2 - Tratamentos de Exceção

Faça os passos abaixo. Não esqueça de fazer `commit` e sincronizar as alterações após cada passo terminado.

### Passo 2.1

O botão `Curtir` e o botão `Comentar` pedem para o usuário o identificador da mensagem.
Mas se o usuário passar um identificador de uma mensagem que não existe, ocorre um erro na aplicação.
O que poderia ser feito para evitar este tipo de problema?
O método no Feed de Notícias poderia alterar seu tipo de retorno, por exemplo?
Quais são as vantagens e desvantagens dessa abordagem?

*... escreva aqui sua resposta ...*

### Passo 2.2:

Altere o método que trata as curtidas no Feed de Notícias para que ele lance uma exceção caso o identificador da mensagem não exista (use exceção do tipo `RuntimeException`).

Teste sua aplicação sem ainda tratar a exceção.
Veja que o erro que aparece é da mensagem que você usou ao criar o objeto da exceção.

Agora faça o tratamento de exceção na classe da `TelaRedeSocial`.
Por enquanto, apenas exiba a mensagem tratada para o usuário (dica: você pode usar a classe `JOptionPane` para exibir uma mensagem).

### Passo 2.3:

Como podemos nos recuperar da exceção em nosso caso?
Poderíamos pedir para o usuário que informasse o identificador da mensagem novamente, certo?

Altere então o código de forma que o programa continue pedindo o identificador para o usuário até ele digitar um identificador válido.

### Passo 2.4:

Depois da alteração anterior, o que acontece com seu programa caso não exista nenhuma mensagem?
Caso não tenha tratado esse caso, faça o tratamento adequado agora.

### Passo 2.5:

Do jeito que fizemos até agora está sendo retornada apenas uma mensagem de erro.
Mas pode ser que queiramos exibir uma mensagem mais amigável para o usuário.
A mensagem do lançamento da exceção é escrita para o programador e nem sempre faz sentido para o usuário.
Dessa forma, pode ser que que, capture a exceção queira usar os dados disponíveis da exceção para montar sua própria mensagem.

Crie então um classe `MensagemNaoEncontradaException` que herda da classe `RuntimeException`.
A classe deverá ter como atributo o identificador da mensagem (obs: veja que a mensagem da exceção pode ser definida dentro da própria classe). 
Dessa forma, ao usá-la para lançarmos uma exceção não precisamos nos preocupar a mensagem (devemos fornecer apenas o identificador da mensagem no construtor).

Faça com que seja lançada uma exceção dessa classe.
Altere a classe da `TelaRedeSocial` para que capture uma exceção desse tipo e defina sua própria mensagem para o usuário buscando o identificador da mensagem a partir do objeto da exceção.

### (Opcional) Passo 2.6:

Altere o tratamento da exceção na classe de `TelaRedeSocial` para que o tratamento funcione apenas caso seja uma exceção do tipo que lançamos.
Acrescente um tratamento genérico (`Exception`) que apenas mostra a mensagem de erro para os demais casos.

Execute o programa para confirmar que do ponto de vista do usuário nada mudou (teste com identificadores válidos e inválidos).

Apenas como forma de testar nossa última alteração, acrescente dentro do método `Curtir` da classe `Mensagem` uma divisão por zero qualquer.
Isso terá um efeito de provocar uma exceção que não é do tipo `MensagemNaoEncontradaException`. 
Dessa
forma, o tratamento deverá cair no caso geral de apenas mostrar a mensagem de erro.

