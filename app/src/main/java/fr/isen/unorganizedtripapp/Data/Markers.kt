package fr.isen.unorganizedtripapp.Data

import fr.isen.unorganizedtripapp.HomeActivity
import fr.isen.unorganizedtripapp.TripBudget

class Markers(budget: TripBudget) {
    val list: HashMap<String, FloatArray> = HashMap<String, FloatArray>()

    init {
        when(budget){
            TripBudget.FAIBLE -> {
                list.put("L'aventure", floatArrayOf(43.27237393403492F, 6.640558029570798F))
                list.put("Port de plaisance", floatArrayOf(43.27266815864741F, 6.636272537099387F))
                list.put("Hôtel Fréjus Sable et Soleil", floatArrayOf(43.425485940670356F, 6.746745311972911F))
                list.put("Brasserie du clos", floatArrayOf(43.619511598802305F, 6.765113014960463F))
                list.put("La Croisette", floatArrayOf(43.54901176753596F, 7.026064203227614F))
                list.put("Restaurant Le Vesuvio", floatArrayOf(43.54797605027173F, 7.0297387398095985F))
                list.put("Musée de préhistoire de Terra Amata", floatArrayOf(43.698086712765374F, 7.289032577337909F))
                list.put("Hôtel de Monaco", floatArrayOf(43.72184429928604F, 7.396410706721197F))
            }
            TripBudget.MOYEN -> {
                list.put("Brasserie Tropézienne", floatArrayOf(43.27057064767187F,
                    6.637781983923451F
                ))
                list.put("Phare de Saint-Tropez", floatArrayOf(
                    43.27330330125803F,
                    6.6340288987509055F
                ))
                list.put("Brasserie Jacques", floatArrayOf(43.4228666740773F, 6.747041524561832F))
                list.put("Hôtel de la Flore", floatArrayOf(43.42433006510498F, 6.769979188884574F))
                list.put("Le Jardin de Bambous du Mandarin", floatArrayOf(43.62808685358527F,
                    6.816882867346597F
                ))
                list.put("Bobo bistro", floatArrayOf(43.551316938889876F, 7.0227314047833165F))
                list.put("Le Marché Forville", floatArrayOf(43.552372607916745F, 7.012049708000211F))
                list.put("Chez Pipo", floatArrayOf(43.700117565459124F, 7.285022749980067F))
            }
            TripBudget.ELEVE -> {
                list.put("Restaurant Le Goustado Tropézien", floatArrayOf(
                    43.271517720369914F,
                    6.641146923385543F
                ))
                list.put("Airelles Saint-Tropez, Pan Dei Palais", floatArrayOf(
                    43.27074438559892F,
                    6.640995194738057F
                ))
                list.put("Site de Malpasset", floatArrayOf(43.45764882338485F, 6.741042197070169F))
                list.put("Histoire sans faim", floatArrayOf(43.617795994055335F, 6.765804320670661F))
                list.put("Le Palais des Festivals de Cannes", floatArrayOf(43.550530368333646F,
                    7.017977474678248F
                ))
                list.put("Da Laura Cannes", floatArrayOf(43.553125555414795F, 7.019494761153122F))
                list.put("Hôtel Barrière Le Majestic Cannes", floatArrayOf(
                    43.55141010528816F,
                    7.019737526989101F
                ))
                list.put("Musée National Marc Chagall", floatArrayOf(43.70918124129649F,
                    7.2692419596725655F
                ))
            }
        }
    }
}