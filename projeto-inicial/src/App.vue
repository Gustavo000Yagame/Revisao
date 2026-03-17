<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'

const seta = ' ---> ';
const atc = '* ';
const escola = 'SENAI';
const cidade = 'Tubarão';


//atvidade 1
const nome = 'gustavo';
const idade = 17;

//atividade 3 filmes
const filme1 = 'O Poderoso Gianluca';
const filme2 = 'O Senhor sem anel';
const filme3 = 'Re zero';

//const desabilitado = true;
//const habilitado = false;


function desabilitado() {
  return idade < 18;
}

function mostrarAlerta() {
  alert('clicou no botão!');
}

function mmudouSelect(event: Event) {
  alert((event.target as HTMLSelectElement).value);
}
</script>

<template>
   <h1>Ola mundo projeto vue</h1>
   <p> {{ atc }} {{ seta }} Escola: {{ escola.toUpperCase() }} <br />
    <br>
   {{ atc }} {{ seta }} Cidade:  {{ cidade.toUpperCase() }}</p>


    <h1>Atividade 1 (3 filmes)</h1>
    <p>{{ atc }} {{ seta }} Filme 1: {{ filme1 }} <br />
    <br>
    {{ atc }} {{ seta }} Filme 2: {{ filme2 }} <br />
    <br>
    {{ atc }} {{ seta }} Filme 3: {{ filme3 }}</p>


    <h1>Atividade 1 parte 2 (nome e idade)</h1>
    <p>{{ atc }} {{ seta }} Nome: {{ nome }} <br />
    <br>
    {{ atc }} {{ seta }} Idade: {{ idade }}</p>
    

    <button @disabled = "desabilitado" class="btn btn-primary">Teste habilitado</button>
    <button @click="mostrarAlerta" class="btn btn-primary">Clique aqui</button>

    <br><br>
     <select @change="mmudouSelect"($event) class="form-select" name = "test">
      <option value="opcao1">Opção 1</option>
      <option value="opcao2">Opção 2</option>
      <option value="opcao3">Opção 3</option>
    </select>

    <br>
  <h1>Atividade 2 </h1>
  
</template>

<style>

select {
  width: 200px;
}
* {
  background-color: #000000;
}


h1 {
  color: red;
}

p {
  color: white;
}
</style>