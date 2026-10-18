/*
 * Copyright (c) 2026 Alireza Khodakarami
 *
 * Licensed under the LPGL-3.0, (read the "LICENSE" file in repo);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.gnu.org/licenses/lgpl-3.0.en.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dynamero.jilibs.platform.services;

import com.dynamero.jilibs.client.interfaces.ExtendedMenuProvider;
import com.dynamero.jilibs.client.interfaces.ServerMenuFactory;
import com.dynamero.jilibs.contracts.annotations.*;
import com.dynamero.jilibs.network.IntegerPayload;
import com.dynamero.jilibs.platform.services.registrars.utils.ExtendedMenuFactory;
import com.dynamero.jilibs.platform.services.registrars.utils.IModScopedRegistrar;
import com.dynamero.jilibs.platform.services.registrars.utils.handles.MenuTypeHandle;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.OptionalInt;

@Developer("TheMentor")
@CreatedAt("2026-10-18")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public interface IMenuService extends IModScopedRegistrar<IMenuService>
{
    ResourceKey<MenuType<?>> key(String name);

    /**
     * Returns an iterable of all blocks
     * registered through this registrar instance.
     * Useful for datagen loot table generation (getKnownBlocks) or any other place you
     * need the access to the list.
     */
    Iterable<? extends MenuType<?>> getList();

    /**
     * Example Usage :
     * <pre><code>
     *     // Inside your block entity when you want to open the menu
     *     if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer)
     *     {
     *          // Using a lambda:
     *          Services.MENU.open(
     *              serverPlayer,
     *              targetEntity,
     *              targetEntity.getId(),
     *              (containerId, playerInv, p, entity) ->
     *                  new MachineMenu(containerId, playerInv, entity)
     *          );
     *     }
     */
    <T extends Entity, M extends AbstractContainerMenu> OptionalInt open(Player player, T entity, int entityId,
                                        ServerMenuFactory<M, T> serverFactory);

    default @Nullable <T extends Entity, M extends AbstractContainerMenu> MenuProvider createProvider(T entity, int entityId,
                                                                     ServerMenuFactory<M, T> serverFactory)
    {
        return new ExtendedMenuProvider<>(){

            @Override
            public @Nullable AbstractContainerMenu createMenu(int containerId, @NonNull Inventory inventory, @NonNull Player player)
            {
                return serverFactory.create(containerId, inventory, player, entity);
            }

            @Override
            public @NonNull Component getDisplayName()
            {
                return entity.getDisplayName();
            }

            @Override
            public Object getScreenOpeningData(ServerPlayer player)
            {
                return new IntegerPayload(entityId);
            }
        };
    }

    /**
     * Registers an extended MenuType with client-side synchronization payload.
     *
     * @param name Registry path
     * @param factory Factory to construct the menu on the client
     * @param codec StreamCodec for reading the extra data on client and writing on server
     */
    <T extends AbstractContainerMenu, D> MenuTypeHandle<MenuType<?>> registerExtendedMenuType(
            String name,
            ExtendedMenuFactory<T, D> factory,
            StreamCodec<? super RegistryFriendlyByteBuf, D> codec
    );
}