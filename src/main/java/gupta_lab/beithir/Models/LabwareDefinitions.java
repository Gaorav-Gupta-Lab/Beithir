package gupta_lab.beithir.Models;

public final class LabwareDefinitions {
    private static final String[] SUPPORTED_LABWARE_TYPES = {
            "8_well_strip_tubes_200ul",
            "bigwell_96_tuberack_200ul_dilution_tube",
            "stacked_96_well",
            "biorad_ddpcr_plate_aluminum_block_100ul",
            "eppendorftwin.tecpcrplates_96_aluminumblock_150ul",
            "parhelia_temp_module_with_biorad_ddpcr_plate_100ul",
            "parhelia_temp_module_with_twintec_ddpcr_plate_150ul",
            "opentrons_96_tiprack_300ul",
            "opentrons_96_filtertiprack_200ul",
            "opentrons_96_tiprack_20ul",
            "opentrons_96_filtertiprack_20ul",
            "screwcap_24_tuberack_500ul",
            "opentrons_24_tuberack_generic_2ml_screwcap",
            "opentrons_24_tube_rack_vwr_microfuge_tube_1.5ml",
            "vwrscrewcapcentrifugetube5ml_15_tuberack_5000ul"
    };

    public static String[] getSupportedLabwareTypes() {
        return SUPPORTED_LABWARE_TYPES.clone(); // Return copy to prevent modification
    }

    private LabwareDefinitions() {} // Prevent instantiation
}

