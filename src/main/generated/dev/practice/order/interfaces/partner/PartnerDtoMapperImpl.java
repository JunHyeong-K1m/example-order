package dev.practice.order.interfaces.partner;

import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerCommand.PartnerCommandBuilder;
import dev.practice.order.domain.partner.PartnerInfo;
import dev.practice.order.interfaces.partner.PartnerDto.RegisterRequest;
import dev.practice.order.interfaces.partner.PartnerDto.RegisterResponse;
import dev.practice.order.interfaces.partner.PartnerDto.RegisterResponse.RegisterResponseBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-11T15:47:38+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class PartnerDtoMapperImpl implements PartnerDtoMapper {

    @Override
    public PartnerCommand of(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        PartnerCommandBuilder partnerCommand = PartnerCommand.builder();

        partnerCommand.partnerName( registerRequest.getPartnerName() );
        partnerCommand.businessNo( registerRequest.getBusinessNo() );
        partnerCommand.email( registerRequest.getEmail() );

        return partnerCommand.build();
    }

    @Override
    public RegisterResponse of(PartnerInfo partnerInfo) {
        if ( partnerInfo == null ) {
            return null;
        }

        RegisterResponseBuilder registerResponse = RegisterResponse.builder();

        registerResponse.partnerToken( partnerInfo.getPartnerToken() );
        registerResponse.partnerName( partnerInfo.getPartnerName() );
        registerResponse.businessNo( partnerInfo.getBusinessNo() );
        registerResponse.email( partnerInfo.getEmail() );
        registerResponse.status( partnerInfo.getStatus() );

        return registerResponse.build();
    }
}
