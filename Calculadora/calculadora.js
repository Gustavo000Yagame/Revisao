let soma
let subtracao   
let multiplicacao
let divisao
function calcular(){
    const numero1 = parseFloat(document.getElementById('numero1').value)
    const numero2 = parseFloat(document.getElementById('numero2').value)
    const operacao = document.getElementById('operacao').value
}
switch(operacao){
    case 'sumar':
        soma = numero1 + numero2
        document.getElementById('resultado').textContent = `Resultado: ${soma}`
        break
    case 'diminuir':
        subtracao = numero1 - numero2
        document.getElementById('resultado').textContent = `Resultado: ${subtracao}`
        break

}