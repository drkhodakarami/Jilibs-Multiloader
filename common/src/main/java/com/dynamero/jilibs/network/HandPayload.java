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

package com.dynamero.jilibs.network;

import com.dynamero.jilibs.contracts.annotations.*;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * Represents a custom payload containing a player hand (e.g., main hand, off hand).
 *
 * @param hand The interaction hand for the payload
 */
@SuppressWarnings("unused")
@Developer("TheMentor")
@CreatedAt("2026-10-08")
@ModifiedAt("2026-10-18")
@ModifiedBy("TheMentor")
@Website("https://dynamero.com")
@Repository("https://github.com/drkhodakarami/")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")
@Modrinth("https://modrinth.com/user/jiraiyah")
public record HandPayload(InteractionHand hand) implements CustomPacketPayload
{
    /**
     * The unique identifier for this custom payload.
     */
    public static final Type<@NotNull HandPayload> ID = new Type<>(Identifier.fromNamespaceAndPath("jilibs", "hand_payload"));

    /**
     * The codec used to serialize and deserialize the HandPayload.
     */
    public static final Codec<HandPayload> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.STRING.xmap(str -> Objects.requireNonNull(InteractionHand.valueOf(str)), InteractionHand::name)
                        .fieldOf("hand").forGetter(HandPayload::hand)
    ).apply(inst, HandPayload::new));

    /**
     * The packet codec used to send and receive the HandPayload.
     */
    public static final StreamCodec<RegistryFriendlyByteBuf, HandPayload> STREAM_CODEC =
            StreamCodec.composite(ByteBufCodecs.STRING_UTF8,
                            payload -> payload.hand().name(),
                            handStr -> new HandPayload(InteractionHand.valueOf(handStr)));

    public static final Codec<List<HandPayload>> LIST_CODEC = CODEC.listOf();

    /**
     * Retrieves the unique identifier for this custom payload.
     *
     * @return the unique identifier
     */
    @Override
    public @NotNull Type<? extends @NotNull CustomPacketPayload> type()
    {
        return ID;
    }
}