package com.skuu.einsteinopenday;

import com.google.android.gms.maps.model.LatLng;
/**
 * Created by Adrian on 14/11/2017.
 */

public class ListaAule
{
    public static Aula[] adule =
    {
            new Aula("Lab Disegno 2", 3, new LatLng(45.616727, 9.383946),
                    new Attivita
                                    ("Laboratorio di manipolazione argilla",
                                            "Esperto: Annapina",
                                            "In questo laboratorio potrai conoscerne le tecniche di modellizzazione  dell’argilla e di realizzazione di oggetti.",
                                            R.drawable.manipolazione_argilla)
                    ),
            new Aula(28, 3, new LatLng(45.616777, 9.384078),
                    new Attivita
                            ("Salone di Pittura – Stampatore",
                                    "Esperto: Paolo Sgroi",
                                    "In quest’aula il nostro esperto Paolo Sgroi spiegherà la tecnica di stampa al torchio, come si è evoluta la stampa nel tempo. Potrai, inoltre, ammirare una delle tele più importanti del pittore Mauro De Carli, nostro collaboratore per il Liceo Artistico.",
                                    R.drawable.pittura)
            ),
            new Aula(12, 2, new LatLng(45.616940, 9.383257),
                    new Attivita
                            ("Presentazione Liceo Scienze applicate",
                                    "Prof. Silva Marina",
                                    "In quest’aula la prof.ssa Silva, vi presenta il liceo Scientifico opzione Scienze Applicate , il quadro orario, il potenziamento motorio  e linguistico, le nuove metodologie didattiche, gli sbocchi.",
                                    R.drawable.galassia)
            ),
            new Aula(2, 2, new LatLng(45.616730, 9.383149),
                    new Attivita
                            ("Presentazione Indirizzo Biologico-Sanitario",
                                    "Prof. Erba",
                                    "In quest’aula la prof.ssa Erba vi presenta l’indirizzo Biotecnologie Sanitarie e Ambientali, il quadro orario, le attività laboratoriali, gli sbocchi professionali.",
                                    R.drawable.farmaci)
            ),
            new Aula("Lab. di Chimica", 2, new LatLng(45.616778, 9.382995),
                    new Attivita
                            ("Dai colori alla chimica in cucina",
                                    "Prof. Tornaghi",
                                    R.drawable.cucina)
            ),
            new Aula("Lab. Chimica Organica", 2, new LatLng(45.616811, 9.383092),
                    new Attivita
                            ("I profumi e gli olii essenziali",
                                    "Prof. Breglia",
                                    R.drawable.profumo)
            ),
            new Aula("Lab. Chimica Fisica", 2, new LatLng(45.616143, 9.384155),
                    new Attivita
                            ("Dalle reazioni alla corrente elettrica",
                                    "Prof. Siragusa - Prof. Gazzaneo",
                                    R.drawable.corrente)
            ),
            new Aula("Lab. di Microbiologia", 2, new LatLng(45.616100, 9.384023),
                    new Attivita
                            ("Tutti i segreti del microscopio",
                                    "Prof. Palermo",
                                    R.drawable.microscopio)
            ),
            new Aula("Lab. Disegno 1", 3, new LatLng(45.616999, 9.383804),
                    new Attivita
                            ("Dall’idea all’oggetto",
                                    "Prof. Cocina - Prof. Cazzaniga - Prof. Previtali",
                                    "In questo laboratorio il prof Cocina e Previtali vi spiegheranno le tecniche per la progettazione e stampa di un oggetto mediante stampa 3D.",
                                    R.drawable.disegno)
            ),
            new Aula(13, 4, new LatLng(45.616947, 9.383382),
                    new Attivita
                            ("Informazioni sul Liceo Sportivo",
                                    "Prof. Riva",
                                    R.drawable.calcio)
            ),
            new Aula("Lab. Sistemi 2", 1, new LatLng(45.615952, 9.383956),
                    new Attivita
                            ("Presentazione Ind. Elettronico: Robot… il tuo futuro",
                                    "Prof. Cerri - Prof. Pagano",
                                    R.drawable.robot)
            ),
            new Aula("Lab. TDP", 1, new LatLng(45.616034, 9.383868),
                    new Attivita
                            ("Progettazione di apparecchiature elettroniche",
                                    "Prof. Nava",
                                    R.drawable.progettazione_chip)
            ),
            new Aula("Lab. Elettronica", 1, new LatLng(45.615927, 9.383650),
                    new Attivita
                            ("Alla scoperta delle apparecchiature elettroniche",
                                    "Prof. Racanati",
                                    R.drawable.chip)
            ),
            new Aula("Lab. Sistemi 1", 0, new LatLng(45.616018, 9.384107),
                    new Attivita
                            ("Presentazione ind. Informatico: dall’hardware al software… un percorso innovativo!",
                                    "Prof. Iannì",
                                    "Il prof. Iannì presenta l’indirizzo informatico; quindi il piano orario, le discipline di indirizzo, le attività che vengono svolte, le certificazioni Cisco a cui aderiamo, gli sbocchi professionali.",
                                    R.drawable.tastiera)
            ),
            new Aula("Biologia", 2, new LatLng(45.617178, 9.383921),
                    new Attivita
                            ("La biologia intorno a noi",
                                    "Prof. Trifiletti",
                                    R.drawable.dna)
            ),
            new Aula("Lab. Informatica", 0, new LatLng(45.616194, 9.384556),
                    new Attivita
                            ("Realizziamo un’App - Costruiamo un sito web",
                                    "Prof. Purgatorio - Prof. Campesan",
                                    "In questo laboratorio potrai vedere da vicino come si sviluppa un’App, un sito web, un programma in Java o in C….il mondo del software come tu lo immagini.",
                                    R.drawable.html)
            ),
            new Aula("Lab. Cisco", 0, new LatLng(45.616597, 9.384398),
                    new Attivita
                            ("Incontriamo gli apparati Cisco",
                                    "Prof. Catalano - Prof. Gaglione",
                                    "In questo Laboratorio Cisco potrai vedere da vicino gli apparati di rete Cisco quali router, switch fondamentali per la creazione di una rete informatica.",
                                    R.drawable.cisco)
            ),
            new Aula(25, 3, new LatLng(45.616980, 9.384117),
                    new Attivita
                            ("Immagini e parole: lettura di un'opera d'arte",
                                    "Prof. Tresoldi",
                                    "In quest’aula la prof. Tresoldi terrà una lezione aperta sulla lettura di un’opera d’arte, una interessante esperienza che ti permetterà di capire il valore dell’arte.",
                                    R.drawable.libri)
            ),
            new Aula(20, -1, new LatLng(45.617072, 9.383625),
                    new Attivita
                            ("Le certificazioni linguistiche… una finestra sul mondo!",
                                    "Prof. Fea",
                                    "In quest’aula la prof.ssa Fea vi spiegherà il valore delle certificazioni linguistiche e le attività inerenti l’area linguistica che vengono svolte all’interno dell’Istituto.",
                                    R.drawable.lingue)
            ),
            new Aula(39, -1, new LatLng(45.616428, 9.384592),
                    new Attivita
                            ("Alternanza Scuola Lavoro",
                                    "Prof. Russo",
                                    R.drawable.ufficio)
            ),
            new Aula("Aula 3.0", -1, new LatLng(45.616832, 9.384237),
                    new Attivita
                            ("Lab. grafico-multimediale. Giornalino scolastico. I nostri video",
                                    "Prof. Imperatore - Esperto: Andrea Ligabo",
                                    "Nella cornice dell'innovativa aula 3.0, la redazione di Click!, giornalino d'istituto, scrive e impagina articoli, presentando un'antologia di video prodotti dagli studenti dell'Einstein. Contemporaneamente, gli studenti dell'Artistico svolgono un laboratorio di elaborazione grafia delle immagini.",
                                    R.drawable.giornalino)
            ),
            new Aula(27, -1, new LatLng(45.616927, 9.384167),
                    new Attivita
                            ("Presentazione della scuola con i video",
                                    "Alunni Scopazzo e Dinella 5D",
                                    "In questa aula i nostri alunni mostreranno i video più belli sulla scuola realizzati dal nostro ex studente Davide Piras.",
                                    R.drawable.videocamera)
            ),
            new Aula("Polifunzionale", -1, new LatLng(45.616263, 9.384725),
                    new Attivita
                            ("Le nostre eccellenze",
                                    "Resp. Prof. Donatella Bonati",
                                    R.drawable.podium)
            )
    };
}
