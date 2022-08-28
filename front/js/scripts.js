
function verificaAutenticacao(){
    if(sessionStorage.getItem("token") == null){
        window.location.href = "/front/signin/";
    }
}


function domReady(cb) {
    (function checkDomReady() {
      var state = document.readyState;
      if (state == 'loaded' || state == 'complete') cb();
      else setTimeout(checkDomReady, 200);
    })();
  };
  
  domReady(function() {
    $(".loader").hide();
  });

//   função loader
function loader(){
    $(".loader").html(`
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
    `);
} 

// VERIFICAÇÃO DA DATA VÁLIDA
// FUNções de data da compra
const dataAtual = () =>{
    var data = new Date();
    var dia = String(data.getDate()).padStart(2, '0');
    var mes = String(data.getMonth() + 1).padStart(2, '0');
    var ano = data.getFullYear();
    return `${ano}-${mes}-${dia}`;
    
}

// função Header
function footer(){
        $(".footer").html(`
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
                    </li>
                    <li>
                        <a
                        class="grey-text text-lighten-3"
                        href="https://github.com/alefvieira"
                        target="_blank"
                        >Alef Vieira</a
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

function header(){
    $(".header").html(`
    <section class="barra-menu">
        <header>
            <nav>
                <a href="/" class="logo"><i class="material-icons">add_to_queue</i>ES DEV</a>

                <div class="mobile-menu">
                    <div class="line1"></div>
                    <div class="line2"></div>
                    <div class="line3"></div>
                </div>

                <ul class="nav-list">
                    <li><a href="/">Início</a></li>
                    <li><a href="/front/medicamento/">Medicamento</a></li>
                    <li><a href="/front/medico/">Medico</a></li>
                    <li><a href="/front/paciente/">Paciente</a></li>
                    <li>
                        <a href="/front/signin/" class="waves-effect btn green">
                            <i class="material-icons left">check</i>Sign In
                        </a>
                        <a href="/front/signup/" class="waves-effect btn orange">
                            <i class="material-icons left">check</i>Sign Up
                        </a>
                    </li>
                    <li v-on:click="deslogar()">
                        <a class="waves-effect btn red">
                            <i class="material-icons left">block</i>Sair
                        </a>
                    </li>
                </ul>
            </nav>
        </header>
    </section>
    `)
}