package br.com.starosky.timetrackerconverter.service;

import br.com.starosky.timetrackerconverter.common.GeneralUtils;
import br.com.starosky.timetrackerconverter.model.ColumnType;
import br.com.starosky.timetrackerconverter.model.HoursInfoOutput;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class HoursInfoService {

    public List<HoursInfoOutput> getHoursInfo(MultipartFile file) {
        List<String[]> lines = getLinesFromFile(file);
        if (lines.isEmpty()) throw new RuntimeException("File is empty or not formatted correctly.");
        List<HoursInfoOutput> outputs = new ArrayList<>();
        for (String[] line : lines) {
            HoursInfoOutput output = new HoursInfoOutput();
            for (int i = 0; i < line.length; i++) {
                switch (ColumnType.valueOf(i)) {
                    case DAY -> output.setDate(GeneralUtils.parseDate(line[i]));
                    case HCM_HOURS -> output.setHcmHours(Double.valueOf(GeneralUtils.getFinalDecimalString(line[i])));
                    case JIRA_HOURS -> output.setJiraHours(Double.valueOf(GeneralUtils.getFinalDecimalString(line[i])));
                    default -> {}
                }
            }
            outputs.add(output);
        }
        return outputs;
    }

    private List<String[]> getLinesFromFile(MultipartFile file) {
        try {
            String[] splitLines = new String(file.getBytes()).split("\n");
            List<String[]> lines = new ArrayList<>();
            for (int i = 1; i < splitLines.length; i++)
                lines.add(splitLines[i].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
            return lines;
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + e.getMessage(), e);
        }
    }
}
