# Lançador de Dados

&emsp; Este repositório contém uma aplicação Android em Kotlin para um lançador de dados. Ele faz parte de uma atividade avaliativa em sala de aula no Inteli. 

## Raciocínio para a resolução do problema

&emsp; Primeiro, fiz o fork do repositório e clonei-o no meu Android Studio. Em seguida, resolvi os problemas lógicos do código, enquanto o aplicativo buildava em meu celular. Achei, inicialmente, que o problema lógico era apenas que a função ``Random.nextInt(6)`` não incluia o 6. Logo, só mudei-a para ``Random.nextInt(7)``. Depois de alguns testes, porém, percebi também que ela incluia indevidamente o zero. Então, estudando a documentação: https://api.flutter.dev/flutter/dart-math/Random/nextInt.html, retornei a chamada da função com 6 como parâmetro e adicionei um como se segue: ``Random.nextInt(6) + 1``. Perceba que a documentação usada é do Flutter não do Kotlin. Se eu tivesse percebido isso, teria usado ``Random.nextInt(from = 1, until = 7)``, mas o método do Flutter também funcionou.

&emsp; Em seguida, adicionei os outros dados. Para tanto, apenas alterei o ``val dados = listOf("D6")`` para ``val dados = listOf("D6", "D10", "D20", "D100")``. Além disso, adicionei linhas como ``"D10" -> Random.nextInt(10) + 1`` no valorSorteado. Essa etapa aconteceu sem problemas e foi quando o aplicativo finalmente buildou em meu celular.

&emsp; Para ir além, inseri as imagens das faces do D6 e imagens dos outros dados. Usei a [documentação do Android Studio](https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images?hl=pt-br#2) até o passo 3 e consegui importar uma imagem. Esse processo foi bem díficil porque ocorre de forma muito diferente do que eu estava familiarizado. Esperava apenas inserir a imagem em um diretório e importá-la. No entanto, tive de usar o Resource Manager e lidar com vários problemas de tipagem para conseguir inserir e mudar a imagem que estava sendo mostrada na tela. Ademais, para este "ir além", tive de cortar uma imagem de faces de um D6 no Canva em 6 partes e baixar cada uma.

## Teve uso de IA?

&emsp; Sim, apenas na parte do "ir além", mas com grande insucesso. A única parte em que foi útil foi para me lembrar de usar _remember_ e não ``var imagem = 0``. No entanto, o tutorial foi muito mais valioso no processo como um todo.


