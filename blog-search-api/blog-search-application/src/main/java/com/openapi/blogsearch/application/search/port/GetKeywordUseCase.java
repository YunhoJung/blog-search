package com.openapi.blogsearch.application.search.port;

import com.openapi.blogsearch.application.search.port.dto.KeywordData;
import java.util.List;

public interface GetKeywordUseCase {

    List<KeywordData> getTop10Keywords();

}
