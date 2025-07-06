package br.com.starosky.timetrackerconverter.controller;

import br.com.starosky.timetrackerconverter.model.HoursInfoOutput;
import br.com.starosky.timetrackerconverter.service.HoursInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/hours-info")
public class HoursInfoController {

    @Autowired
    private HoursInfoService hoursInfoService;

    @RequestMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @GetMapping
    public List<HoursInfoOutput> getHoursInfo(@RequestPart MultipartFile file) {
        return hoursInfoService.getHoursInfo(file);
    }
}
