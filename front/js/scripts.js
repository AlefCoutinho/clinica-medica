function verificaAutenticacao() {
  if (sessionStorage.getItem('token') == null) {
    window.location.href = '/front/signin/'
  }
}

function domReady(cb) {
  ;(function checkDomReady() {
    var state = document.readyState
    if (state == 'loaded' || state == 'complete') cb()
    else setTimeout(checkDomReady, 200)
  })()
}

domReady(function () {
  $('.loader').hide()
})

//   função loader
function loader() {
  $('.loader').html(`
    <div class="radar-spinner">
        <div class="circle">
            <div class="circle-inner-container">
            <div class="circle-inner"></div>
            </div>
        </div>
        
        <div class="circle">
            <div class="circle-inner-container">
            <div class="circle-inner"></div>
            </div>
        </div>
        
        <div class="circle">
            <div class="circle-inner-container">
            <div class="circle-inner"></div>
            </div>
        </div>
        
        <div class="circle">
            <div class="circle-inner-container">
            <div class="circle-inner"></div>
            </div>
        </div>
    </div>
    `)
}

// VERIFICAÇÃO DA DATA VÁLIDA
// FUNções de data da compra
const dataAtual = () => {
  var data = new Date()
  var dia = String(data.getDate()).padStart(2, '0')
  var mes = String(data.getMonth() + 1).padStart(2, '0')
  var ano = data.getFullYear()
  return `${ano}-${mes}-${dia}`
}

// função Header
function footer() {
  $('.footer').html(`
            <footer class="page-footer grey darken-4">
            <div class="center container">
                <div class="row">
                <div class="col l6 s12">
                    <h5 class="white-text">About :3</h5>
                    <p class="grey-text text-lighten-4">
                    Terms of Use - Privacy Policy
                    </p>
                </div>
                <div class="col l4 offset-l2 s12">
                    <h5 class="white-text">GITHUB</h5>
                    <ul>
                    <li>
                        <a
                        class="grey-text text-lighten-3"
                        href="https://github.com/ericdourado"
                        target="_blank"
                        >Eric Dourado</a
                        >
                        <a
                        class="grey-text text-lighten-3"
                        href="https://github.com/alefvieira"
                        target="_blank"
                        >/ Alef Vieira</a
                        >
                    </li>
                    <li>
                        <a
                        class="grey-text text-lighten-3"
                        href="https://github.com/lobistico"
                        target="_blank"
                        >Eduardo Rodrigues</a
                        >
                    </li>
                    <li>
                        <a
                        class="grey-text text-lighten-3"
                        href="https://github.com/renatoplopes"
                        target="_blank"
                        >Renato Lopes</a>
                        <a
                        class="grey-text text-lighten-3"
                        href="https://github.com/BrunnoMGomes"
                        target="_blank"
                        >/ Bruno Gomes</a>
                    </li>
                    </ul>
                </div>
                </div>
            </div>
            <div
                class="center footer-copyright"
                style="border-top: 1px solid lightslategrey"
            >
                <div class="container">
                © 2022 Copyright Eric, Eduardo, Alef, Luiz, Renato, Paulo
                </div>
            </div>
            </footer>
        `)
}

function header() {
  if (sessionStorage.getItem('token') == null) {
    $('.header').html(`
    <header>
        <nav class="nav-extended grey darken-4">
        <div class="nav-wrapper">
            <a href="/" class="center brand-logo"
            ><i class="material-icons">local_hospital</i>ES DEV</a
            >
            <ul id="nav-mobile" class=" hide-on-small-only">
            <div class="right">
                <li>
                <a
                    href="/front/signin/"
                    class="waves-effect waves-light btn green"
                    ><i class="material-icons left">check</i>Entrar</a
                >
                </li>
            </ul>
        </div>
        <div class="hide-on-med-and-up	 nav-content">
            <ul class="tabs tabs-transparent">
                <li>
                    <a
                    href="/front/signin/"
                    class="waves-effect waves-light btn green"
                    ><i class="material-icons left">check</i>Entrar</a
                    >
                </li>
                </ul>
        </nav>
    </header>
    `)
  } else {
    $('.header').html(`
    <header>
        <nav class="nav-extended grey darken-4">
        <div class="nav-wrapper">
            <a href="/" class="center brand-logo"
            ><i class="material-icons">local_hospital</i>ES DEV</a
            >
            <ul id="nav-mobile" class=" hide-on-med-and-down">
            <div class="left">
                <li><a href="/">Realizar Cadastros</a></li>
                <li><a href="/front/medicamento/">Medicamento</a></li>
                <li><a href="/front/medico/">Medico</a></li>
                <li><a href="/front/paciente/">Paciente</a></li>
            </div>
            </ul>
            <ul id="nav-mobile" class=" hide-on-small-only">
            <div class="right">
                <li v-on:click="deslogar()">
                <a href="/front/signin/" class="waves-effect waves-light btn red"
                    ><i class="material-icons left">block</i>Sair</a
                >
                </li>
            </ul>
        </div>
        <div class="hide-on-large-only	 nav-content">
            <ul class="tabs tabs-transparent">
            <li class="tab"><a href="/">Pagina Inicial</a></li>
            <li class="tab"><a href="/front/medicamento/">Medicamento</a></li>
            <li class="tab"><a href="/front/medico/">Medico</a></li>
            <li class="tab"><a href="/front/paciente/">Paciente</a></li>

            </ul>
        </div>
        <div class="hide-on-med-and-up	 nav-content">
            <ul class="tabs tabs-transparent">
                <li v-on:click="deslogar()">
                    <a href="/front/signin/" class="waves-effect waves-light btn red"
                    ><i class="material-icons left">block</i>Sair</a
                    >
                </li>
                </ul>
        </nav>
    </header>
    `)
  }
}
