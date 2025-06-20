Documentação do Projeto: PC Studio App
1. Visão Geral e Objetivo do Projeto
O "PC Studio App" nasceu como um projeto de extensão, com o objetivo de aplicar conceitos de desenvolvimento de software em uma aplicação Android funcional. Ao longo do desenvolvimento, o escopo evoluiu para um projeto com potencial de mercado, inspirado em plataformas de agendamento como o "Ajatus".

O objetivo final é criar uma plataforma mobile completa que sirva como um diretório de estúdios e artistas de tatuagem. O aplicativo visa conectar dois públicos principais:

Usuários Finais: Pessoas que buscam encontrar e contatar artistas de tatuagem, visualizar seus portfólios e, futuramente, agendar sessões.
Artistas e Estúdios: Profissionais que desejam uma plataforma para divulgar seus trabalhos, alcançar novos clientes e gerenciar seu perfil profissional.
A estratégia de longo prazo inclui um modelo de monetização que combina a exibição de anúncios para os usuários e a oferta de planos de assinatura (com diferentes níveis de funcionalidade) para os estúdios cadastrados.

2. Tecnologias, Ferramentas e Arquitetura
O aplicativo foi construído com uma base tecnológica moderna e robusta, seguindo as melhores práticas recomendadas para o desenvolvimento Android.

Linguagem de Programação: Kotlin, a linguagem oficial e preferida pelo Google para o desenvolvimento Android, garantindo um código mais seguro, conciso e moderno.
Arquitetura da Interface (UI):
Android Views com XML: Utiliza a abordagem tradicional e consolidada de construir a interface do usuário, separando a estrutura visual (definida em arquivos .xml) da lógica de programação (em arquivos .kt).
Material Design: Incorpora componentes da biblioteca com.google.android.material para garantir um design consistente, moderno e intuitivo, com elementos como CardView, BottomNavigationView e CollapsingToolbarLayout.
IDE (Ambiente de Desenvolvimento): Android Studio.
Sistema de Build: Gradle, responsável por compilar o código-fonte e gerenciar todas as bibliotecas externas (dependências).
Bibliotecas e Integrações Chave:
AndroidX (AppCompat, Core, etc.): O conjunto fundamental de bibliotecas do Google que fornece componentes essenciais de UI, funcionalidades e compatibilidade com versões mais antigas do Android.
RecyclerView: O componente central para a exibição de listas longas e dinâmicas de forma eficiente. Foi utilizado para criar:
A lista horizontal de "Estilos Populares" na tela de Início.
A lista vertical de "Artistas e Estúdios".
A lista vertical de "Agendamentos".
A galeria em grade do "Portfólio" na tela de detalhes do artista.
Glide: Uma poderosa biblioteca de carregamento de imagens, responsável por baixar, decodificar e exibir as fotos dos artistas e seus portfólios a partir de links da internet, com otimização de cache e performance.
Backend como Serviço (BaaS) - Google Firebase:
Cloud Firestore: Utilizado como o banco de dados NoSQL na nuvem. É a "fonte da verdade" para os dados dinâmicos do aplicativo, como perfis de estúdios e listas de estilos.
Cloud Storage: (Configurado e pronto para uso futuro) O serviço de armazenamento de arquivos do Firebase, destinado a receber uploads de imagens (fotos de perfil, portfólios) diretamente dos artistas nos planos "Premium".
Monetização - Google AdMob:
O SDK do Google Mobile Ads foi integrado e configurado no projeto. A exibição de um banner de anúncio de teste na tela de Artistas valida a infraestrutura para futura monetização.
3. Fases do Desenvolvimento e Funcionalidades Implementadas
O projeto foi dividido em fases, e o progresso atual reflete a conclusão das etapas iniciais de construção da base do aplicativo.

Fase 1 a 3: Estrutura, Navegação e Listas de Exemplo
Estrutura de Autenticação: Foram criadas as telas de Boas-vindas, Login (LoginActivity), Cadastro (RegisterActivity), "Esqueci a Senha" e o esqueleto da tela de "Cadastro de Negócio".
Refatoração da Navegação: O design de navegação foi modernizado, substituindo um antigo menu lateral por uma BottomNavigationView com quatro seções principais: Início, Artistas, Agenda e Perfil.
Arquitetura de Fragments: O aplicativo foi estruturado para usar Fragments para cada seção principal, hospedados pela HomeActivity.
Listas com RecyclerView: Foram implementadas listas funcionais para Estilos, Artistas e Agendamentos, inicialmente populadas com dados de exemplo escritos no código para validar a UI e a lógica dos Adapters.
Fase 4: Enriquecimento da Experiência do Usuário
Tela de Detalhes Dinâmica: Foi criada a ArtistDetailActivity, que recebe os dados do artista clicado e exibe suas informações específicas.
Funcionalidade de Contato: Foram adicionados ícones clicáveis para WhatsApp, Instagram e Facebook, que abrem o link correspondente no aplicativo ou navegador. A visibilidade dos ícones é controlada dinamicamente com base nos dados do artista.
Galeria de Portfólio: Foi implementada uma galeria em grade (GridLayoutManager) na tela de detalhes, que exibe as imagens de portfólio do artista.
Visualização em Tela Cheia: Foi adicionada a funcionalidade que permite ao usuário clicar em uma imagem do portfólio para visualizá-la em uma tela cheia dedicada (FullScreenImageActivity).
Fase 5: Implementação de Anúncios
Configuração do AdMob: O SDK do Google Mobile Ads foi adicionado e configurado no projeto.
Exibição de Banner: Um banner de anúncio de teste foi implementado com sucesso na tela de listagem de artistas, validando a configuração para futura monetização.
Fase 6: Conexão com o Backend (Estado Atual)
Configuração do Firebase: O projeto foi conectado a um projeto Firebase, com os serviços Firestore Database e Cloud Storage configurados e suas regras de segurança ajustadas para o modo de desenvolvimento.
Cadastro Real de Estúdios: A tela "Cadastre seu Negócio" foi refatorada para salvar os dados preenchidos no formulário (incluindo links de imagens) diretamente em uma coleção studios no Cloud Firestore.
Listas Dinâmicas do Firestore: As telas de "Início" (para Estilos) e "Artistas" foram modificadas para, em vez de usar dados de exemplo, buscar e exibir os dados em tempo real do banco de dados Firestore.
