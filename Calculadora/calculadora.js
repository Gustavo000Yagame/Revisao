let soma
let subtracao   
let multiplicacao
let divisao

function calcular(event){
    event.preventDefault()
    const numero1 = parseFloat(document.getElementById('num1').value)
    const numero2 = parseFloat(document.getElementById('num2').value)
    const operacao = document.getElementById('operacao').value
    
    switch(operacao){
        case 'somar':
            soma = numero1 + numero2
            document.getElementById('resultado').textContent = `Resultado: ${soma}`
            break
        case 'diminuir':
            subtracao = numero1 - numero2
            document.getElementById('resultado').textContent = `Resultado: ${subtracao}`
            break
        case 'multiplicar':
            multiplicacao = numero1 * numero2
            document.getElementById('resultado').textContent = `Resultado: ${multiplicacao}`
            break
        case 'dividir':
            if (numero2 !== 0) {
                divisao = numero1 / numero2
                document.getElementById('resultado').textContent = `Resultado: ${divisao}`
            } else {
                document.getElementById('resultado').textContent = 'Erro: Divisao por zero nao e permitida.'
            }
            break
    }
}

document.getElementById('calculadora').addEventListener('submit', calcular)
