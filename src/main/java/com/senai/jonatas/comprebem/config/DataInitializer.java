package com.senai.jonatas.comprebem.config;

import com.senai.jonatas.comprebem.entity.Produto;
import com.senai.jonatas.comprebem.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) {
        if (produtoRepository.count() != 60) {
            log.info("Inicializando base de dados com 60 produtos para teste de paginação...");
            produtoRepository.deleteAll();

            List<Produto> produtos = new ArrayList<>();

            // 6 Produtos com 'Cadeira' para teste de busca
            produtos.add(criar("Cadeira Gamer ThunderX3 TC3", "1199.90", "Móveis", "Cadeira gamer ergonômica com apoio lombar e cervical ajustáveis", 15, "https://images.unsplash.com/photo-1598550476439-6847785fcea6"));
            produtos.add(criar("Cadeira de Escritório Presidente Giratória", "899.00", "Móveis", "Cadeira executiva com revestimento em couro sintético e base cromada", 20, "https://images.unsplash.com/photo-1580481077195-c22ae2b33054"));
            produtos.add(criar("Cadeira Ergonômica Diretor Mesh", "649.99", "Móveis", "Cadeira de escritório com encosto respirável em tela mesh e apoio de braço", 25, "https://images.unsplash.com/photo-1505797149-43b0069ec26b"));
            produtos.add(criar("Cadeira Gamer Reclinável Profissional", "1499.00", "Móveis", "Cadeira gamer com inclinação de 180 graus e almofadas de espuma de alta densidade", 10, "https://images.unsplash.com/photo-1598550476439-6847785fcea6"));
            produtos.add(criar("Cadeira Fixa Secretária com Braços", "299.90", "Móveis", "Cadeira de recepção estofada com pés de aço e pintura eletrostática", 30, "https://images.unsplash.com/photo-1580481077195-c22ae2b33054"));
            produtos.add(criar("Cadeira Gamer Husky Avalanche RGB", "1349.50", "Móveis", "Cadeira gamer com iluminação RGB personalizável e rodízios em nylon", 12, "https://images.unsplash.com/photo-1598550476439-6847785fcea6"));

            // Periféricos e Informática (Itens 7 a 25)
            produtos.add(criar("Teclado Mecânico RGB Switch Blue", "289.90", "Periféricos", "Teclado gamer mecânico com switches azuis táteis e iluminação RGB", 40, "https://images.unsplash.com/photo-1587829741301-dc798b83add3"));
            produtos.add(criar("Teclado Mecânico Compacto 60%", "319.00", "Periféricos", "Teclado mecânico compacto formato 60% switch red silencioso", 35, "https://images.unsplash.com/photo-1587829741301-dc798b83add3"));
            produtos.add(criar("Teclado Sem Fio Ergonômico", "249.90", "Periféricos", "Teclado ergonômico bipartido com descanso de pulso acolchoado", 18, "https://images.unsplash.com/photo-1587829741301-dc798b83add3"));
            produtos.add(criar("Mouse Gamer Óptico 16000 DPI", "199.90", "Periféricos", "Mouse gamer com sensor PixArt 3389 e 7 botões programáveis", 50, "https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7"));
            produtos.add(criar("Mouse Sem Fio Silencioso", "89.90", "Periféricos", "Mouse óptico sem fio com cliques silenciosos e receptor nano USB", 60, "https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7"));
            produtos.add(criar("Mousepad Gamer Extra Grande 90x40cm", "79.90", "Periféricos", "Mousepad Speed com bordas costuradas e base de borracha antiderrapante", 75, "https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7"));
            produtos.add(criar("Monitor LED 24 Pol Full HD 75Hz", "599.00", "Monitores", "Monitor IPS com bordas ultrafinas, conexão HDMI e VGA", 22, "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf"));
            produtos.add(criar("Monitor Gamer 27 Pol 165Hz 1ms IPS", "1299.00", "Monitores", "Monitor gamer com tecnologia FreeSync, taxa de atualização de 165Hz e HDR", 16, "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf"));
            produtos.add(criar("Monitor Ultrawide 29 Pol LG", "1099.90", "Monitores", "Monitor 21:9 UltraWide IPS com sRGB 99% e OnScreen Control", 14, "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf"));
            produtos.add(criar("Monitor Curvo Gamer 32 Pol 144Hz", "1799.00", "Monitores", "Monitor curvo 1500R resolução QHD com alta taxa de contraste", 9, "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf"));
            produtos.add(criar("Headset Gamer 7.1 Surround", "259.90", "Áudio", "Headset com drivers de 50mm, som surround 7.1 e microfone cancelador de ruído", 30, "https://images.unsplash.com/photo-1546435770-a3e426bf472b"));
            produtos.add(criar("Fone de Ouvido Bluetooth TWS", "189.90", "Áudio", "Fone intra-auricular sem fio com case de carregamento e autonomia de 24h", 45, "https://images.unsplash.com/photo-1590658268037-6bf12165a8df"));
            produtos.add(criar("Headphone Over-Ear com ANC", "499.00", "Áudio", "Headphone Bluetooth com cancelamento ativo de ruído e almofadas confortáveis", 20, "https://images.unsplash.com/photo-1505740420928-5e560c06d30e"));
            produtos.add(criar("Caixa de Som Bluetooth Portátil 20W", "229.00", "Áudio", "Caixa de som à prova d'água IPX7 com graves potentes e bateria de longa duração", 35, "https://images.unsplash.com/photo-1608043152269-423dbba4e7e1"));
            produtos.add(criar("Microfone Condensador USB Profissional", "349.90", "Áudio", "Microfone cardióide para podcast, streaming e gravações com tripé", 25, "https://images.unsplash.com/photo-1590658268037-6bf12165a8df"));
            produtos.add(criar("Webcam Full HD 1080p 60fps", "279.00", "Periféricos", "Webcam com foco automático, correção de luz baixa e microfone duplo", 28, "https://images.unsplash.com/photo-1587829741301-dc798b83add3"));
            produtos.add(criar("Suporte Articulado para Monitor a Gás", "179.90", "Acessórios", "Suporte de mesa padrão VESA com pistão a gás para telas até 32 polegadas", 40, "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf"));
            produtos.add(criar("Mesa Gamer em L com Tampo Amadeirado", "549.00", "Móveis", "Mesa de canto espaçosa para setup gamer com suporte para headset", 8, "https://images.unsplash.com/photo-1518455027359-f3f8164ba6bd"));
            produtos.add(criar("Mesa de Escritório Regulável Elétrica", "1899.00", "Móveis", "Mesa standing desk com ajuste elétrico de altura e memória programável", 5, "https://images.unsplash.com/photo-1518455027359-f3f8164ba6bd"));

            // Hardware e Computadores (Itens 26 a 40)
            produtos.add(criar("Notebook Ultrafino 15.6 Pol Core i5 16GB", "3499.00", "Informática", "Notebook leve e rápido com SSD NVMe de 512GB e tela antirreflexo", 12, "https://images.unsplash.com/photo-1496181133206-80ce9b88a853"));
            produtos.add(criar("Notebook Gamer Core i7 RTX 4060 16GB", "6899.00", "Informática", "Notebook gamer de alta performance com teclado RGB e tela 144Hz", 7, "https://images.unsplash.com/photo-1603302576837-37561b2e2302"));
            produtos.add(criar("Placa de Vídeo GeForce RTX 4070 12GB", "4299.00", "Hardware", "Placa gráfica com arquitetura Ada Lovelace, DLSS 3 e Ray Tracing", 10, "https://images.unsplash.com/photo-1587202372775-e229f172b9d7"));
            produtos.add(criar("Processador AMD Ryzen 7 5700X", "1149.00", "Hardware", "Processador de 8 núcleos e 16 threads com clock máximo de 4.6GHz", 15, "https://images.unsplash.com/photo-1591799264318-7e6ef8ddb7ea"));
            produtos.add(criar("Processador Intel Core i5 13400F", "1089.00", "Hardware", "Processador com 10 núcleos híbridos e suporte a DDR4 e DDR5", 14, "https://images.unsplash.com/photo-1591799264318-7e6ef8ddb7ea"));
            produtos.add(criar("Placa Mãe B550M AM4 Micro-ATX", "629.00", "Hardware", "Placa mãe com dissipadores reforçados, slots M.2 PCIe 4.0 e rede Gigabit", 20, "https://images.unsplash.com/photo-1518770660439-4636190af475"));
            produtos.add(criar("Memória RAM 16GB DDR4 3200MHz", "219.00", "Hardware", "Módulo de memória com dissipador de alumínio e suporte XMP 2.0", 50, "https://images.unsplash.com/photo-1562976540-1502c2145186"));
            produtos.add(criar("Memória RAM 32GB Kit (2x16) DDR5 5600MHz", "699.00", "Hardware", "Kit de memória dual-channel de alta velocidade para desktops modernos", 25, "https://images.unsplash.com/photo-1562976540-1502c2145186"));
            produtos.add(criar("SSD NVMe M.2 1TB Leitura 3500MB/s", "399.90", "Hardware", "Armazenamento em estado sólido com PCIe Gen 3x4 ultrarrápido", 45, "https://images.unsplash.com/photo-1597872200969-2b65d56bd16b"));
            produtos.add(criar("SSD NVMe M.2 2TB Leitura 7000MB/s", "799.00", "Hardware", "SSD PCIe Gen 4x4 ideal para criadores de conteúdo e gamers exigentes", 18, "https://images.unsplash.com/photo-1597872200969-2b65d56bd16b"));
            produtos.add(criar("Fonte de Alimentação ATX 650W 80 Plus Bronze", "389.00", "Hardware", "Fonte de alta eficiência com PFC ativo e cabos flat pretos", 30, "https://images.unsplash.com/photo-1587202372775-e229f172b9d7"));
            produtos.add(criar("Gabinete Gamer Mid Tower com 4 Fans RGB", "329.90", "Hardware", "Gabinete com lateral de vidro temperado e excelente fluxo de ar", 20, "https://images.unsplash.com/photo-1587202372775-e229f172b9d7"));
            produtos.add(criar("Water Cooler 240mm RGB Radiador Duplo", "419.00", "Hardware", "Sistema de refrigeração líquida com bomba silenciosa e ventoinhas PWM", 15, "https://images.unsplash.com/photo-1587202372775-e229f172b9d7"));
            produtos.add(criar("Roteador Wi-Fi 6 Gigabit AX3000", "359.00", "Redes", "Roteador dual band com tecnologia OFDMA, beamforming e rede mesh", 25, "https://images.unsplash.com/photo-1544197150-b99a580bb7a8"));
            produtos.add(criar("Switch Gigabit Ethernet 8 Portas", "129.90", "Redes", "Switch de mesa com carcaça de metal durável e portas auto-MDI/MDIX", 35, "https://images.unsplash.com/photo-1544197150-b99a580bb7a8"));

            // Acessórios e Smartphones (Itens 41 a 50)
            produtos.add(criar("Cabo HDMI 2.1 Ultra High Speed 8K 2m", "49.90", "Acessórios", "Cabo blindado com conectores banhados a ouro e taxa de 48Gbps", 80, "https://images.unsplash.com/photo-1544197150-b99a580bb7a8"));
            produtos.add(criar("Cabo DisplayPort 1.4 144Hz 2m", "55.00", "Acessórios", "Cabo de alta fidelidade para suporte a monitores de alta taxa de quadros", 70, "https://images.unsplash.com/photo-1544197150-b99a580bb7a8"));
            produtos.add(criar("Hub USB-C 7 em 1 com HDMI 4K", "169.90", "Acessórios", "Adaptador multifuncional com portas USB 3.0, leitor SD e Power Delivery", 45, "https://images.unsplash.com/photo-1622445262464-84b1456045b6"));
            produtos.add(criar("Carregador Turbo 65W GaN USB-C", "139.00", "Acessórios", "Carregador compacto com tecnologia GaN para celular e notebook", 50, "https://images.unsplash.com/photo-1583863788434-e58a36330cf0"));
            produtos.add(criar("Power Bank 20000mAh Carregamento Rápido", "179.90", "Acessórios", "Bateria externa portátil com visor digital e saídas USB-C e USB-A", 40, "https://images.unsplash.com/photo-1609592424888-e8c1b3f94ec6"));
            produtos.add(criar("Smartphone 5G 128GB Câmera Tripla 50MP", "1499.00", "Celulares", "Smartphone moderno com tela fluida de 90Hz e bateria de 5000mAh", 18, "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9"));
            produtos.add(criar("Smartphone Flagship 256GB AMOLED 120Hz", "3899.00", "Celulares", "Processador de ponta, gravação 8K e certificação de resistência IP68", 10, "https://images.unsplash.com/photo-1592899677977-9c10ca588bbd"));
            produtos.add(criar("Tablet 10.4 Pol 64GB com Caneta Stylus", "1399.00", "Celulares", "Tablet versátil para estudos e entretenimento com som estéreo Dolby Atmos", 15, "https://images.unsplash.com/photo-1561154464-82e9adf32764"));
            produtos.add(criar("Smartwatch com GPS e Monitor Cardíaco", "459.00", "Wearables", "Relógio inteligente com resistência à água 5ATM e dezenas de modos de treino", 28, "https://images.unsplash.com/photo-1523275335684-37898b6baf30"));
            produtos.add(criar("Smartband com Sensor de Oxigênio SpO2", "199.90", "Wearables", "Pulseira inteligente com tela colorida AMOLED e monitoramento do sono", 40, "https://images.unsplash.com/photo-1575311373937-040b8e1fd5b6"));

            // Games e Eletrodomésticos (Itens 51 a 60)
            produtos.add(criar("Console de Videogame 1TB Edição Digital", "3699.00", "Games", "Console de última geração com carregamento ultrarrápido em SSD e 120fps", 8, "https://images.unsplash.com/photo-1606813907291-d86efa9b94db"));
            produtos.add(criar("Controle Sem Fio para PC e Console", "349.90", "Games", "Controle ergonômico com gatilhos adaptáveis e bateria recarregável", 30, "https://images.unsplash.com/photo-1600080972464-8e5f35f63d08"));
            produtos.add(criar("Volante Gamer com Pedais e Force Feedback", "1999.00", "Games", "Simulador de direção com rotação de 900 graus e acabamento em couro", 6, "https://images.unsplash.com/photo-1600080972464-8e5f35f63d08"));
            produtos.add(criar("Lâmpada Inteligente Smart LED 10W Wi-Fi", "59.90", "Casa Inteligente", "Lâmpada RGB compatível com comandos de voz por assistentes virtuais", 60, "https://images.unsplash.com/photo-1550985616-10810253b84d"));
            produtos.add(criar("Fita LED RGB Inteligente 5 Metros", "119.00", "Casa Inteligente", "Fita de iluminação decorativa com sincronização de música e controle via app", 40, "https://images.unsplash.com/photo-1550985616-10810253b84d"));
            produtos.add(criar("Tomada Inteligente Wi-Fi 16A com Monitoramento", "69.90", "Casa Inteligente", "Plugue inteligente para agendamento e medição de consumo elétrico", 55, "https://images.unsplash.com/photo-1550985616-10810253b84d"));
            produtos.add(criar("Cafeteira Elétrica Programável Inox", "259.90", "Eletro", "Cafeteira com jarra térmica de aço inoxidável e timer programável", 20, "https://images.unsplash.com/photo-1517668808822-9ebb02f2a0e6"));
            produtos.add(criar("Fritadeira Elétrica sem Óleo Air Fryer 4L", "389.00", "Eletro", "Fritadeira com cesto antiaderente, controle de temperatura até 200C e timer", 18, "https://images.unsplash.com/photo-1584269600464-37b1b58a9fe7"));
            produtos.add(criar("Liquidificador Potente 1200W Copo de Vidro", "219.90", "Eletro", "Liquidificador com 12 velocidades, função pulsar e lâminas serrilhadas", 22, "https://images.unsplash.com/photo-1570222094114-d054a817e56b"));
            produtos.add(criar("Aspirador de Pó Vertical 2 em 1 1300W", "199.00", "Eletro", "Aspirador leve com filtro HEPA lavável que retém ácaros e bactérias", 25, "https://images.unsplash.com/photo-1558317374-067fb5f30001"));

            produtoRepository.saveAll(produtos);
            log.info("Carga inicial concluída com sucesso: {} produtos cadastrados.", produtos.size());
        } else {
            log.info("Base de dados já possui {} produtos. Carga inicial ignorada.", produtoRepository.count());
        }
    }

    private Produto criar(String nome, String preco, String categoria, String descricao, Integer quantidade, String imagem) {
        Produto p = new Produto();
        p.setNome(nome);
        p.setPreco(new BigDecimal(preco));
        p.setCategoria(categoria);
        p.setDescricao(descricao);
        p.setQuantidade(quantidade);
        p.setImagem(imagem);
        return p;
    }
}
