# Lançador de Dados

&emsp; Este repositório contém uma aplicação Android em Kotlin para um lançador de dados. Ele faz parte de uma atividade avaliativa em sala de aula no Inteli. 

## Raciocínio para a resolução do problema

&emsp; Primeiro, forkei o repositório e clonei-o no meu Android Studio. Em seguida, resolvi os problemas lógicos do código enquanto o aplicativo buildava em meu celular. O problema lógico era que devido ao funcionamento da função ``Random.nextInt(6)``, o dado estava dando os seguintes resultados: **0**, 1, 2, 3, 4, 5. Primeiro, apenas percebi o problema de não estar indo até 6, então, só mudei a função para ``Random.nextInt(7)``. Depois de alguns testes, porém, percebi o problema do 0 e estudando a documentação: https://api.flutter.dev/flutter/dart-math/Random/nextInt.html, mudei a linha para ``Random.nextInt(6) + 1``. Perceba que essa documentação é do Flutter não do Kotlin. Se eu tivesse percebido isso, teria usado ``Random.nextInt(from = 1, until = 7)``, mas o método do Flutter também funcionou.

&emsp; Em seguida, adicionei os outros dados. Para tanto, apenas alterei o ``val dados = listOf("D6")`` para ``val dados = listOf("D6", "D10", "D20", "D100")``. Além disso, adicionei linhas como ``"D10" -> Random.nextInt(10) + 1`` no valorSorteado. Essa etapa aconteceu sem problemas.

&emsp; Por último, usei a documentação 


