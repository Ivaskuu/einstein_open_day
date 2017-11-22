package com.skuu.einsteinopenday;

import com.google.android.gms.maps.model.LatLng;
/**
 * Created by Adrian on 14/11/2017.
 */

public class ListaAule
{
    public static Aula[] adule =
    {
            new Aula("Lab Disegno 2", 4, new LatLng(45.616727, 9.383946),
                    new Attivita
                            ("Laboratorio di manipolazione argilla",
                                    "Esperto: Annapina",
                                    "Un laboratorio per sperimentare le tecniche di modellizzazione dell’argilla, manipolandola e plasmando forme artistiche.",
                                    R.drawable.manipolazione_argilla)
                    ),
            new Aula(28, 4, new LatLng(45.616777, 9.384078),
                    new Attivita
                            ("Salone di Pittura – Stampatore",
                                    "Esperto: Paolo Sgroi",
                                    "L’affascinante tecnica di stampa al torchio e la sua evoluzione, in compagnia di un video sul Liceo Artistico e di una delle tele più importanti del pittore Mauro De Carli, nostro collaboratore per il Liceo Artistico.",
                                    R.drawable.pittura)
            ),
            new Aula(12, 3, new LatLng(45.616940, 9.383257),
                    new Attivita
                            ("Presentazione Liceo Scienze applicate",
                                    "Prof. Silva Marina",
                                    "Presentazione del liceo Scientifico opzione Scienze Applicate: quadro orario, potenziamento motorio e linguistico, nuove metodologie didattiche, sbocchi.",
                                    R.drawable.galassia)
            ),
            new Aula(2, 2, new LatLng(45.616730, 9.383149),
                    new Attivita
                            ("Presentazione Indirizzo Biologico-Sanitario",
                                    "Prof. Erba",
                                    "Presentazione dell’indirizzo Biotecnologie Sanitarie e Ambientali: quadro orario, attività laboratoriali, nuove metodologie didattiche, sbocchi professionali.",
                                    R.drawable.farmaci)
            ),
            new Aula("Lab. di Chimica", 2, new LatLng(45.616778, 9.382995),
                    new Attivita
                            ("Dai colori alla chimica in cucina",
                                    "Prof. Tornaghi",
                                    "Il mondo della chimica e della cucina sono intrecciati tra loro, in un abbraccio di mille colori.",
                                    R.drawable.cucina)
            ),
            new Aula("Lab. Chimica Organica", 2, new LatLng(45.616811, 9.383092),
                    new Attivita
                            ("I profumi e gli olii essenziali",
                                    "Prof. Breglia",
                                    "Produrre profumi e olii essenziali è una raffinata forma d’arte, da esplorare con tutti i sensi.",
                                    R.drawable.profumo)
            ),
            new Aula("Lab. Chimica Fisica", 2, new LatLng(45.616143, 9.384155),
                    new Attivita
                            ("Dalle reazioni alla corrente elettrica",
                                    "Prof. Siragusa - Prof. Gazzaneo",
                                    "Un laboratorio elettrizzante, alla scoperta della scintilla da cui sgorga l’energia che muove i nostri prodotti tecnologici.",
                                    R.drawable.corrente)
            ),
            new Aula("Lab. di Microbiologia", 3, new LatLng(45.616100, 9.384023),
                    new Attivita
                            ("Tutti i segreti del microscopio",
                                    "Prof. Palermo",
                                    "Un salto verso l’infinitamente piccolo, alla ricerca dell’invisibile. Sei pronto a guardare il mondo con occhi diversi?",
                                    R.drawable.microscopio)
            ),
            new Aula("Lab. di Microbiologia", 2, new LatLng(45.616100, 9.384023),
                    new Attivita
                            ("Tutti i segreti del microscopio",
                                    "Prof. Palermo",
                                    "Il microscopio è uno strumento atto a dare immagini ingrandite di oggetti molto piccoli rivelando dettagli altrimenti invisibili. Sei pronto a guardare il mondo con occhi diversi?",
                                    R.drawable.microscopio)
            ),
            new Aula("Lab. Disegno 1", 4, new LatLng(45.616999, 9.383804),
                    new Attivita
                            ("Dall’idea all’oggetto",
                                    "Prof. Cocina - Prof. Cazzaniga - Prof. Previtali",
                                    "Le tecniche per la progettazione e la realizzazione di un oggetto mediante stampa 3D.",
                                    R.drawable.disegno)
            ),
            new Aula(13, 3, new LatLng(45.616947, 9.383382),
                    new Attivita
                            ("Informazioni sul Liceo Sportivo",
                                    "Prof. Riva",
                                    "Trova qui tutte le informazioni che ti servono sul nuovo liceo sportivo.",
                                    R.drawable.calcio)
            ),
            new Aula("Lab. Sistemi 2", 1, new LatLng(45.615952, 9.383956),
                    new Attivita
                            ("Presentazione Ind. Elettronico: Robot… il tuo futuro",
                                    "Prof. Cerri - Prof. Pagano",
                                    "Ti sei mai chiesto come funziona un robot? Non aspettare oltre e vieni a scoprire come crearne uno.",
                                    R.drawable.robot)
            ),
            new Aula("Lab. TDP", 1, new LatLng(45.616034, 9.383868),
                    new Attivita
                            ("Progettazione di apparecchiature elettroniche",
                                    "Prof. Nava",
                                    "Dall’idea al progetto, esplorando il mondo dell’elettronica.",
                                    R.drawable.progettazione_chip)
            ),
            new Aula("Lab. Elettronica", 1, new LatLng(45.615927, 9.383650),
                    new Attivita
                            ("Alla scoperta delle apparecchiature elettroniche",
                                    "Prof. Racanati",
                                    "Un viaggio sorprendente nei circuiti e nelle loro applicazioni.",
                                    R.drawable.chip)
            ),
            new Aula("Lab. Sistemi 1", 0, new LatLng(45.616018, 9.384107),
                    new Attivita
                            ("Presentazione ind. Informatico: dall’hardware al software… un percorso innovativo!",
                                    "Prof. Iannì",
                                    "Presentazione dell’indirizzo informatico: piano orario, discipline di indirizzo, attività, certificazioni Cisco a cui aderiamo, sbocchi professionali.",
                                    R.drawable.tastiera)
            ),
            new Aula("Lab. Biologia", 2, new LatLng(45.617178, 9.383921),
                    new Attivita
                            ("La biologia intorno a noi",
                                    "Prof. Trifiletti",
                                    "È tutto partito da una sola cellula. Scopri cos'è successo dopo.",
                                    R.drawable.dna)
            ),
            new Aula("Lab. Informatica", 0, new LatLng(45.616194, 9.384556),
                    new Attivita
                            ("Realizziamo un'app - Costruiamo un sito web",
                                    "Prof. Purgatorio - Prof. Campesan",
                                    "Come si sviluppa un'App, un sito web, un programma in Java o in C. Il mondo del software come tu lo immagini!",
                                    R.drawable.html)
            ),
            new Aula("Lab. Cisco", 0, new LatLng(45.616597, 9.384398),
                    new Attivita
                            ("Incontriamo gli apparati Cisco",
                                    "Prof. Catalano - Prof. Gaglione",
                                    "Nel laboratorio Cisco a incontrare gli apparati di rete Cisco quali router e switch, fondamentali per la creazione di una rete informatica.",
                                    R.drawable.cisco)
            ),
            new Aula(25, 4, new LatLng(45.616980, 9.384117),
                    new Attivita
                            ("Immagini e parole: lettura di un'opera d'arte",
                                    "Prof. Tresoldi",
                                    "Una lezione aperta sulla lettura di un’opera d’arte, un incontro suggestivo e poetico con la grande arte e i grandi artisti.",
                                    R.drawable.libri)
            ),
            new Aula(20, -1, new LatLng(45.617072, 9.383625),
                    new Attivita
                            ("Le certificazioni linguistiche… una finestra sul mondo!",
                                    "Prof. Fea",
                                    "Il valore delle certificazioni linguistiche e le attività inerenti l’area linguistica che vengono svolte all’interno dell’Istituto.",
                                    R.drawable.lingue)
            ),
            new Aula(39, -1, new LatLng(45.616428, 9.384592),
                    new Attivita
                            ("Alternanza Scuola Lavoro",
                                    "Prof. Russo",
                                    "I progetti di Alternanza Scuola‐Lavoro nascono dall’esigenza di superare la distinzione di tre mondi solo apparentemente lontani tra loro: la scuola, il territorio ed il lavoro. Qui tutto quello che ti serve sapere.",
                                    R.drawable.ufficio)
            ),
            new Aula("Aula 3.0", -1, new LatLng(45.616832, 9.384237),
                    new Attivita
                            ("Lab. grafico-multimediale. Giornalino scolastico. I nostri video",
                                    "Prof. Imperatore - Esperto: Andrea Ligabo",
                                    "Nella cornice dell'innovativa aula 3.0, la redazione di Click!, giornalino d'istituto, scrive e impagina articoli, presentando un'antologia di video prodotti dagli studenti dell'Einstein. Contemporaneamente, gli studenti dell'Artistico svolgono un laboratorio di elaborazione grafica delle immagini.",
                                    R.drawable.giornalino)
            ),
            new Aula(27, -1, new LatLng(45.616927, 9.384167),
                    new Attivita
                            ("Presentazione della scuola con i video",
                                    "Alunni Scopazzo e Dinella 5D",
                                    "In compagnia di alcuni nostri alunni, i video più belli sull’Einstein realizzati dal nostro ex studente Davide Piras. Buona visione!",
                                    R.drawable.videocamera)
            ),
            new Aula("Polifunzionale", -1, new LatLng(45.616263, 9.384725),
                    new Attivita
                            ("Le nostre eccellenze",
                                    "Resp. Prof. Donatella Bonati",
                                    "Gli studenti presentano progetti e lavori che hanno vinto premi nell’anno scolastico 2016/2017. E non sono pochi!",
                                    R.drawable.podium)
            )
    };
}
