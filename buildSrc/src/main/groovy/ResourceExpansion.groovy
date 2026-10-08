import org.gradle.api.Project

class ResourceExpansion {
    private static final List<String> PROPERTY_KEYS = [
            'minecraft_version',
            'minecraft_version_range',
            'fabric_version',
            'fabric_loader_version',
            'mod_name',
            'mod_author',
            'mod_id',
            'mod_license',
            'mod_description',
            'mod_release_type',
            'modrinth_project_id',
            'modrinth_project_token',
            'curseforge_project_id',
            'curseforge_project_token',
            'neoforge_version',
            'neoforge_loader_version_range',
            'mod_credits',
            'java_version',
            'spotless_version',
            'cursegralde_version',
            'minotaur_version',
            'loom_version',
            'neoforge_plugin_version',
            'spongepowered_version',
            'mixinextras_version',
            'jilibs_version',
            'energy_version',
            'pal_version',
            'modmenu_version',
            'badges_lib_version',
            'kyrptonaught_fabric_version',
            'kyrptonaught_neoforge_version',
            'jade_fabric_version',
            'jade_neoforge_version',
            'jei_mc_version',
            'jei_fabric_version',
            'jei_neoforge_version',
            'emi_fabric_version',
            'emi_neoforge_version',
            'rei_fabric_version',
            'rei_neoforge_version',
            'cloth_fabric_version',
            'cloth_neoforge_version',
            'architectury_fabric_version',
            'architectury_neoforge_version',
            'terrablender_fabric_version',
            'terrablender_neoforge_version'
    ]

    static Map<String, Object> getProperties(Project project) {
        Map<String, Object> map = [
                'version': project.version,
                'group'  : project.group
        ]

        for (String key : PROPERTY_KEYS) {
            if(project.hasProperty(key)) {
                map.put(key, project.findProperty(key))
            }
        }

        return map
    }
}